
function newhabit(){
    // 获取所有的input元素
    var inputs = document.querySelectorAll('input');
    var inputValues = {};

// 遍历所有的input元素，获取它们的name和value
    for (var i = 0; i < inputs.length; i++) {
        if (!inputs[i].value) {
            alert(inputs[i].name + "不能为空");
            return;
        }

        inputValues[inputs[i].name] = inputs[i].value;
    }


// 获取textarea的值
    var textarea = document.querySelector('textarea');
    if(!textarea.value){
        alert(textarea.name+"不能为空")
        return;
    }
    inputValues[textarea.name] = textarea.value;
    console.log(inputValues);
    var name = inputValues["名称"];
    var startdate = inputValues["开始日期"];
    var enddate = inputValues["结束日期"];
    var description = textarea.value;

    var jsondata = {"name":name,"startdate":startdate,"enddate":enddate,"description":description}
    $.ajax({
        url:"/newhabit",
        type:"POST",
        data:jsondata,
        dataType:"html",
        success: function(data){
            eval(data);
        }
    })
}