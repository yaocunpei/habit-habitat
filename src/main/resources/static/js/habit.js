// 鼠标左右移动
let box=document.querySelector('.habit')
box.addEventListener('wheel',(event)=>{
    event.preventDefault()
    box.scrollLeft+=event.deltaY
})

