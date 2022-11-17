let specialCharacters = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
function checkInfoInput (){
    Validator({
        errorSelector: '.form-message',
        rules: [
            Validator.isNumber(document.querySelector('#product_amount input'), "0-9"),
            Validator.isCharacters(document.querySelectorAll("#product_size input"), 'a-z A-Z'),
            Validator.isCharacters(document.querySelectorAll("#product_color input"), 'a-z A-Z'),
            Validator.isProductName(document.querySelector("#form-inforProduct__infor #product_name"), 'không chứa ký tự đặc biệt hoặc không để trống'),
            Validator.isNumber(document.querySelector("#form-inforProduct__infor #product_price"), '0-9'),
        ],
    });
}

function Validator(options) {
    function validate(inputElement, rule)
    {
        errorElement =inputElement.parentElement.querySelector(options.errorSelector);
        if(rule.test(inputElement.value)){
            errorElement.innerText = rule.test(inputElement.value);
        }
        else{
            errorElement.innerText = '';
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


Validator.isCharacters = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value) || /[0-9]/.test(value))? message : undefined
        }
    };
}

Validator.isNumber = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return (specialCharacters.test(value) || /[a-zA=Z]/.test(value) || value.trim().length == 0)?  message : undefined
        }
    }
}
Validator.isProductName = function(selector, message){
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value))? message : undefined
        }
    };
}
