-- 语句实现
select count(distinct sno) as flunk from sc where score < 60;

-- 存储过程实现
call countFlunk();

drop procedure if exists countFlunk;
create procedure countFlunk()
begin
    -- 学号以及学号副本
    declare sno_sc, sno_sc_temp varchar(30) default '';
    -- 成绩
    declare score_sc numeric(10, 2) default 0.0;
    -- 计数器
    declare count int default 0;

    -- 游标结束标志
    declare end_sc boolean default false;
    -- sc游标
    declare sc_cursor cursor for select sno, score from sc;
    declare continue handler for not found set end_sc = true;

    -- 遍历数据
    open sc_cursor;
    repeat
        -- 获取下一行数据
        fetch sc_cursor into sno_sc, score_sc;
        -- 游标未读结束
        if not end_sc then
            -- 分数小于60并且学号没有重复
            if score_sc < 60 and not sno_sc_temp = sno_sc then
                -- 计次后记录学号
                set sno_sc_temp = sno_sc;
                -- 计次
                set count = count + 1;
            end if;
        end if;
    until end_sc end repeat;
    close sc_cursor;
    -- 显示结果
    select count;
end;
