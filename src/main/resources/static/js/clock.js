function clock(){
    var selectElem = document.getElementById('selectElem');
    var habit_id = selectElem.options[selectElem.selectedIndex].value;
    var jsondata = {"habit_id":habit_id,"state":1}
    if(!habit_id){
        alert("太棒啦，今天的所有签到都完成了！");
        return 0;
    }
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