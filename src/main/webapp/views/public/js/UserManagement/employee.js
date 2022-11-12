function showSuccessToast(action) {
    let messageConfirm = `Bạn có chắc chắn muốn ${action} không`;
    let message = `Bạn đã ${action} thành công`;
    if(confirm(messageConfirm) == true)
    {
        toast({
            title: "Thành công",
            message: message,
            type: "success",
            duration: 2000
        });
        layer.style.display = "none";
    }
}
function showErrorToast(action) {
    let message = `Bạn đã ${action} thất bại`;
    toast({
        title: "Thất bại",
        message: message,
        type: "error",
        duration: 2000
    });
}

// Toast function
function toast({ title = "", message = "", type = "info", duration = 3000 }) {
    const main = document.getElementById("toast");
    if (main) {
        const toast = document.createElement("div");

        const autoRemoveId = setTimeout(function () {
            main.removeChild(toast);
        }, duration + 1000);

        toast.onclick = function (e) {
            if (e.target.closest(".toast__close")) {
                main.removeChild(toast);
                clearTimeout(autoRemoveId);
            }
        };

        const icons = {
            success: "fas fa-check-circle",
            info: "fas fa-info-circle",
            warning: "fas fa-exclamation-circle",
            error: "fas fa-exclamation-circle"
        };
        const icon = icons[type];
        const delay = (duration / 1000).toFixed(2);

        toast.classList.add("toast", `toast--${type}`);
        toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

        toast.innerHTML = `
                    <div class="toast__icon">
                        <i class="${icon}"></i>
                    </div>
                    <div class="toast__body">
                        <h3 class="toast__title">${title}</h3>
                        <p class="toast__msg">${message}</p>
                    </div>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                `;
        main.appendChild(toast);
    }
}

function employee_control()
{
    checkbox_wastebasket.forEach((item)=>{
        item.addEventListener("click", ()=>{
            let checked = false;
            checkbox_wastebasket.forEach((item)=>{
                if(item.checked == true){
                    checked = true
                    icon_wastebasket.style.display = "block";
                }
            })
            if(checked == false){
                icon_wastebasket.style.display = "none";
            }
        })
    })

    closeFormMember.addEventListener("click", ()=>{
        layer.style.display = "none"
    })


    getInforMember.forEach((item) => {
        item.addEventListener("dblclick", () =>{
            layer.style.display = "block";
            form_informMember.style.display = "block"
            btn_insert.style.display = "none"
            btn_update.style.display = "block";
            btn_delete.style.display = "block";
            getDataTable = item.querySelectorAll("td")
            for (let value = 0; value < InforMember.length; value++)
            {
                InforMember[value].value = getDataTable[value + 2].innerHTML;
            }
            form_informMember.querySelector("#role").value = item.querySelector("td[name=position]").innerHTML
            Reset_validator();
        })
    })

    btn_add.addEventListener("click", showFromInfor)
    function showFromInfor()
    {
        layer.style.display = "block";
        btn_insert.style.display = "block";
        btn_update.style.display = "none";
        btn_delete.style.display = "none";
        InforMember.forEach((input)=>input.value = "")
        Reset_validator();
    }

    btn_insert.addEventListener("click", ()=>{

    })
    btn_update.addEventListener("click", ()=>{

    })
    btn_delete.addEventListener("click", ()=>{
        showSuccessToast("xóa");
    })
    icon_wastebasket.addEventListener("click", ()=>{
        showSuccessToast("xóa");
    })
}


employee_control();