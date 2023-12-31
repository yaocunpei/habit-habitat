function buqian(){
    // 获取select元素
    var selectElem = document.getElementById('selectElem');

// 获取选中的option值
    var habit_id = selectElem.options[selectElem.selectedIndex].value;

// 获取input元素
    var inputElem = document.querySelector('input[type="date"]');

// 获取input的值
    var bqdate = inputElem.value;

    console.log('habit_id ', habit_id);
    console.log('bqdate: ', bqdate);

    var jsondata = {"habit_id":habit_id,"bqdate":bqdate}

    console.log(jsondata);
    $.ajax({
        url:"/buqian",
        type:"POST",
        data:jsondata,
        dataType:"html",
        success: function(data){
            eval(data);
        }
    })
}

