function clock(state){
    var selectElem = document.getElementById('selectElem');
    if (selectElem.options.length === 0) {
        alert("今天的所有习惯都已经打开了，继续抱持");
        return;
    }
    var habit_id = selectElem.options[selectElem.selectedIndex].value;
    var jsondata = {"habit_id":habit_id,"state":state}

    console.log(jsondata);
    $.ajax({
        url:"/attendance",
        type:"POST",
        data:jsondata,
        dataType:"html",
        success: function(data){
            eval(data);
        }
    })
}

