let openSidebar = true;
let sidebar = document.getElementById('sidebar')
let content = document.querySelector('#web_body .content')
document.getElementById('guide-button').addEventListener("click", ()=>{
    if(openSidebar == true)
    {
        openNav();
        openSidebar = false;
    }
    else
    {
        closeNav();
        openSidebar = true;
    }
})
function openNav() {
    sidebar.style.transform = "translateX(0%)";
}
function closeNav() {
    sidebar.style.transform = "translateX(-100%)";
}


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

icon_wastebasket.addEventListener("click", ()=>{
    showSuccessToast("xóa");
})

function Validator(options) {
    function validate(inputElement, rule)
    {
        errorElement = inputElement.parentElement.querySelector(options.errorSelector);
        if(rule.test(inputElement.value)){
            errorElement.innerText = rule.test(inputElement.value);
            inputElement.parentElement.classList.add("invalid");
        }
        else{
            errorElement.innerText = '';
            inputElement.parentElement.classList.remove("invalid");
        }
        return errorElement.innerText? false:true;
    }
    let formElement = document.querySelector(options.form);
    if(formElement)
    {
        formElement.onsubmit = function(e){
            e.preventDefault();
            let isFormValid = true;
            options.rules.forEach((rule)=>{
                let isValid = true;
                if(rule.selector.length >= 1)
                {
                    rule.selector.forEach((item_rule)=>{
                        let inputElement = item_rule;
                        isValid = validate(inputElement, rule);
                    })
                }
                else{
                    let inputElement = rule.selector;
                    isValid = validate(inputElement, rule);
                }
                if(!isValid){
                    isFormValid = false;
                }
            })
            if (options.listImage)
                if(document.querySelectorAll(options.listImage).length == 1)
                    isFormValid = false;


            if(isFormValid)
            {
                showSuccessToast('thực thi');
            }
            else{
                showErrorToast('thực thi');
            }
        }
    }
    options.rules.forEach((rule)=>{
        if(rule.selector.length >= 1)
        {
            rule.selector.forEach((item_rule)=>{
                let inputElement = item_rule;
                inputElement.onblur = function () {
                    validate(inputElement, rule);
                }
                inputElement.oninput = function () {
                    validate(inputElement, rule);
                }
            })
        }
        else{
            let inputElement = rule.selector;
            inputElement.onblur = function () {
                validate(inputElement, rule);
            }
            inputElement.oninput = function () {
                validate(inputElement, rule);
            }
        }
    })
}

