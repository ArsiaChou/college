-- 操作
drop table sc;
select * from sc;
delete from sc where score > 0;

-- 表定义
create table sc
(
    -- 学号
    sno   varchar(30),
    -- 课程号
    cno   varchar(20),
    -- 成绩
    score numeric(10, 2),
    primary key (sno, cno)
) engine = innodb
  default charset = utf8mb4;

-- 表数据
insert into sc (sno, cno, score)
values -- 全及格
       ('s001', 'c001', 60),
       ('s001', 'c002', 60),
       ('s001', 'c003', 60),
       -- 三门不及格
       ('s002', 'c001', 59),
       ('s002', 'c002', 59),
       ('s002', 'c003', 59),
       -- 两门不及格
       ('s003', 'c001', 60),
       ('s003', 'c002', 59),
       ('s003', 'c003', 59),
       -- 一门不及格
       ('s004', 'c001', 60),
       ('s004', 'c002', 60),
       ('s004', 'c003', 59),
       -- 一门不及格
       ('s005', 'c001', 60),
       ('s005', 'c002', 59),
       ('s005', 'c003', 60),
       -- 一门不及格
       ('s006', 'c001', 60),
       ('s006', 'c002', 59),
       ('s006', 'c003', 60),
       -- 全及格
       ('s007', 'c001', 60),
       ('s007', 'c002', 60),
       ('s007', 'c003', 60);



-- 测试
drop table if exists test_a_table;
create table test_a_table (
    name varchar(5),
    primary key (name)
);

insert into test_a_table(name) value ('a1');
insert into test_a_table(name) value ('a2');
insert into test_a_table(name) value ('a3');

select * from test_a_table;

drop procedure  if exists testA;
create procedure testA()
begin
    declare name_ varchar(5) default '';
    declare end_test boolean default false;
    declare test_a_table cursor for select name from test_a_table;
    declare continue handler for not found set end_test = true;

    create table test_a_temp (
      name varchar(5) unique
    );

    open test_a_table;
    repeat
        fetch test_a_table into name_;
        if not end_test then
            insert into test_a_temp value (name_);
        end if;
    until end_test end repeat;
    select * from test_a_temp;
    close test_a_table;
    drop table test_a_temp;

end;

call testA();
show tables;