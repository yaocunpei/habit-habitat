edituser.addEventListener("click", function(event) {

    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var gender = document.getElementById("gender").value;
    var biography = document.getElementById("biography").value;
    // console.log(name);
    // console.log(phone);
    // console.log(email);
    // console.log(gender)
    // console.log(biography)
    if(gender === "男"){
        gender=1;
    }else{
        gender=0;
    }
    // console.log(gender)
    event.preventDefault(); // 阻止按钮的默认行为
    // 在这里执行你自己的代码
    var jsondata = {"name":name,"email":email,"phone":phone,"biography":biography,"gender":gender}
    $.ajax({
        url:"/edituser",
        type:"POST",
        data:jsondata,
        dataType:"html",
        success: function(data){
            eval(data);
        }
    })
});


