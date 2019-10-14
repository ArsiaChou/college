function ajax(options) {
    var pramas = {
        url: '',
        type: 'get',
        data: {},
        success: function (data) {
        },
        error: function (err) {
        },
    };
    options = Object.assign(pramas, options);
    if (options.url) {
        var xhr = XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
        var url = options.url,
            type = options.type.toUpperCase(),
            data = options.data,
            dataArr = [];
        for (let key in data) {
            let value = key + '=' + data[key];
            dataArr.push(value)
        }
        if (type === "GET") {
            url = url + "?" + dataArr.join('&');
            xhr.open(type, url, true);
            xhr.send()
        }
        if (type === "POST") {
            xhr.open(type, url, true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.send(dataArr.join('&'))
        }
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)) {  // 304未修改
                options.success(xhr.responseText)
            } else {
                options.error(xhr.responseText)
            }
        }
    }
}

function loadTable($tag, reload, lines, start) {
    var nothing = '<tr><td colspan="7">Nothing</td></tr>';
    ajax({
        url: 'servlet/master/all',
        type: 'post',
        data: {
            "r": reload,
            "l": lines,
            "s": start
        },
        success: (reply) => {
            var object = JSON.parse(reply);
            var list = object.list;
            // console.log(object);
            if (list.length == 0) $tag.table.innerHTML = nothing;
            if (reload) $tag.length.value = object.size;
            var html_ = '';
            for (var orderMaster of list) {
                html_ += '<tr>';
                html_ += '<td>' + orderMaster.orderNo + '</td>';
                html_ += '<td>' + orderMaster.customerNo + '</td>';
                html_ += '<td>' + orderMaster.saleNo + '</td>';
                html_ += '<td>' + orderMaster.orderSum + '</td>';
                html_ += '<td>' + orderMaster.orderData + '</td>';
                html_ += '<td>' + orderMaster.shipDate + '</td>';
                html_ += '<td>' + orderMaster.invoiceNo + '</td>';
                html_ += '</tr>';
            }

            $tag.table.innerHTML = html_;
        },
        error: (reply) => {
            $tag.table.innerHTML = nothing;
        }
    });
}

function loadReport() {
    var nothing = '<tr><td colspan="7">Nothing</td></tr>';
    ajax({
        url: 'servlet/master/psr',
        type: 'post',
        success: (reply) => {
            console.log(reply);
        },
        error: (reply) => {
            console.log(nothing);
        }
    });
}

window.onload = function (event) {
    // main thing
    var mainThing = {
        table: document.querySelector(".order-master-data"),
        flush: document.querySelector(".flush"),
        last: document.querySelector(".last"),
        next: document.querySelector(".next"),
        length: document.querySelector(".list-length")
    };

    //init
    var lines = 10, start = 0;
    mainThing.flush.addEventListener('click', () => {
        start = 0;
        loadTable(mainThing, true, lines, start);
    });

    mainThing.flush.click();

    mainThing.last.addEventListener('click', () => {
        if (start > 0) {
            start -= 10;
            loadTable(mainThing, false, lines, start);
        } else {
            alert('到达起始位置');
        }
    });

    mainThing.next.addEventListener('click', () => {
        var list_length = parseInt(mainThing.length.value);
        if (start + lines < list_length) {
            start += lines;
            loadTable(mainThing, false, lines, start);
        } else {
            alert('到达尾部');
        }
    });

    // report
    loadReport();
};