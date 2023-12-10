const sign = document.getElementById("sign")



// 获取输入元素
const stunum = document.getElementById('stunum');
const stuphone = document.getElementById('stuphone');
const pw = document.getElementById('pw');
const sub = document.getElementById("sub")
// 获取显示错误信息的p标签
const stunumErr = document.getElementById('dstunum');
const stuphoneErr = document.getElementById('dstuphone');
const pwErr = document.getElementById('pwErr');

// 手机号正则表达式
const phoneReg =  /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;;

var n = false;
var p = false;
// 输入时校验-学号
stunum.addEventListener('input', () => {
    // 10位学号   0位不算格式错误
    if(stunum.value.length != 10 && stunum.value.length != 0) {
        stunumErr.innerText = '学号格式错误';
        stunumErr.style.display = 'inline-block';
        sub.disabled = true;
        n = false
    } else{
        stunumErr.style.display = 'none';
        stuphone.style.display = "inline-block";
        n = true
        if(stunum.value.length == 0 || n){
            sub.disabled = false;
        }
    }
});
//输入时校验-手机号
stuphone.addEventListener('input', () => {
    // 11位号码    0位不算格式错误
    if((stuphone.value.length !== 11 || !phoneReg.test(stuphone.value)) && stuphone.value.length !== 0 ){
        stuphoneErr.innerText = '手机号格式错误';
        stuphoneErr.style.display = "inline-block";
        sub.disabled = true;
        p = false
    } else{
        stuphoneErr.style.display = "none";
        pw.style.display = "inline-block";
        sub.disabled = false;
        p = true;
        if(n && p){
            sub.disabled = false;
        }
    }
});



sign.addEventListener("click", function(event) {
    var stunumv = document.getElementById("stunum").value;
    var stuphonev = document.getElementById("stuphone").value;
    var pwv = document.getElementById("pw").value;
    var stuname = document.getElementById("stuname").value;
    event.preventDefault(); // 阻止按钮的默认行为
    // 在这里执行你自己的代码
    var jsondata = {"stunum":stunumv,"stuphone":stuphonev,"pw":pwv,"stuname":stuname}
    $.ajax({
        url:"/processsign",
        type:"POST",
        data:jsondata,
        dataType:"html",
        success: function(data){
            eval(data);
        }
    })
});