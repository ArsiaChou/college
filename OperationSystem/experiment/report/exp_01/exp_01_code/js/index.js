var isEmpty = (value) => {
        if (value == null || value.trim() == "")
            return true;
        else
            return false;
    },
    sortFun = (a, b) => {
        var reply = b.priority - a.priority;

        if (reply <= 0) {
            if (b.finish) reply = -reply;
        } else {
            if (a.finish) reply = -reply;
        }

        return reply;
    },
    wait = (obj) => {
        obj.state = 'W';
        obj.type = 'wait';
    },
    run = (obj) => {
        obj.state = 'R';
        obj.type = 'run';
        obj.cpu += 1;
        obj.priority -= 3;
    },
    finish = (obj) => {
        obj.state = 'F';
        obj.type = 'finish';
        obj.finish = true;
    };


window.onload = (event) => {
    var main = new Vue({
        el: "#main",
        data: {
            form: {
                name: null,
                priority: null,
                time: null
            },
            process_list: [],
            finish_list: []
        },
        methods: {
            add: () => {
                var form = main.$data.form,
                    process_list = main.$data.process_list;
                if (isEmpty(form.name)) {
                    alert("进程名为空");
                } else if (isEmpty(form.priority)) {
                    alert("优先级为空");
                } else if (isEmpty(form.time) || form.time < 0) {
                    alert("运行时长为空或筱小于零");
                } else {
                    process_list.push({
                        id: process_list.length + 1,
                        name: form.name,
                        priority: form.priority,
                        time: form.time,
                        cpu: 0,
                        state: 'W',
                        type: 'wait',
                        finish: false
                    });

                    form.name = null;
                    form.priority = null;
                    form.time = null;
                }
            },
            clear: () => {
                main.$data.process_list = [];
                main.$data.finish_list = [];
            },
            next: () => {
                var list = main.$data.process_list;

                //是否运行完成
                if (list.length == 0) {
                    alert("全部运行完毕");
                    return;
                }

                if (list[0].state == 'R') wait(list[0]);

                list.sort(sortFun);

                //是否运行时间为零
                if (list[0].time == 0) {
                    finish(list[0]);
                    var temp = list[0];
                    list.splice(0, 1);
                    main.$data.finish_list.push(temp);
                }

                run(list[0]);

                if (list[0].cpu == list[0].time) {
                    finish(list[0]);
                    var temp = list[0];
                    list.splice(0, 1);
                    main.$data.finish_list.push(temp);
                }
            },
            defaultValue: () => {
                main.$data.process_list = [
                    { id: 1, name: 'a', priority: 23, time: 3, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 2, name: 'b', priority: 30, time: 2, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 3, name: 'c', priority: 54, time: 5, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 4, name: 'd', priority: 60, time: 6, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 5, name: 'e', priority: 32, time: 2, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 6, name: 'f', priority: 28, time: 2, cpu: 0, state: 'W', finish: false, type: 'wait' },
                    { id: 7, name: 'g', priority: 30, time: 0, cpu: 0, state: 'W', finish: false, type: 'wait' }
                ];

                main.$data.finish_list = [];
            }
        }
    });
}