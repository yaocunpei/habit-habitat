// 获取页面中所有的input和textarea元素
var inputs = document.getElementsByTagName('input');
var textareas = document.getElementsByTagName('textarea');

// 保存初始值
var initialValues = {};

for(var i = 0; i < inputs.length; i++) {
    initialValues[inputs[i].name] = inputs[i].value;
}

for(var i = 0; i < textareas.length; i++) {
    initialValues[textareas[i].name] = textareas[i].value;
}

function habit_edit(button) {
    var habit_id = button.id;
    // 获取新值并与初始值进行比较
    var inputsNew = document.getElementsByTagName('input');
    var textareasNew = document.getElementsByTagName('textarea');
    var hasChanged = false;

    for(var i = 0; i < inputsNew.length; i++) {
        if(initialValues[inputsNew[i].name] !== inputsNew[i].value) {
            hasChanged = true;
            break;
        }
    }

    for(var i = 0; i < textareasNew.length; i++) {
        if(initialValues[textareasNew[i].name] !== textareasNew[i].value) {
            hasChanged = true;
            break;
        }
    }

    if (hasChanged) {
        var inputsData = [];
        for (var i = 0; i < inputsNew.length; i++) {
            inputsData.push({
                name: inputsNew[i].name,
                value: inputsNew[i].value
            });
        }

        var textareaData = [];
        for (var i = 0; i < textareasNew.length; i++) {
            textareaData.push({
                name: textareasNew[i].name,
                value: textareasNew[i].value
            });
        }

        console.log(inputsData[1].value);
        console.log(textareaData[0].value);
        var startdate = inputsData[0].value;
        var enddate = inputsData[1].value;
        var description = textareaData[0].value;
        var jsondata = {"habit_id":habit_id,"startdate":startdate,"enddate":enddate,"description":description}
        $.ajax({
            url:"/edithabit",
            type:"POST",
            data:jsondata,
            dataType:"html",
            success: function(data){
                eval(data);
            }
        })
    } else {
        alert("请修改后再确认！")
    }
}
