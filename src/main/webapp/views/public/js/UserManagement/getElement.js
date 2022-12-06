let tableThead = document.querySelector(".table_wrapper thead")
let tableBody = document.querySelector(".table_wrapper tbody")
tableThead.innerHTML = `
<tr>
    <th></th>
    <th>ID</th>
    <th>Full Name</th>
    <th>PhoneNumber</th>
    <th>Email</th>
    <th>PassWord</th>
    <th>Address</th>
    <th>Salary</th>
    <th>Role</th>
    <th>Created_at</th>
    <th>Deleted_at</th>                     
</tr>
`
for(let i = 0; i<100; i++)
{
    tableBody.innerHTML += `<tr>
                            <td><input type="checkbox"></td>
                            <td>${i+1}</td>
                            <td>Trịnh Hoàng Phúc</td>
                            <td>0328614013</td>
                            <td>hoangphuc${i+1}@gmail.com</td>
                            <td>phuc0201</td>
                            <td>An Giang</td>
                            <td>50000000</td>
                            <td name = "position">Nhân viên</td>
                            <td>2022-11-07</td>
                            <td>null</td>
                        </tr>`
}


let layer = document.getElementById("layer");
let checkbox_wastebasket = document.querySelectorAll(".table_wrapper input")
let icon_wastebasket = document.querySelector(".content__header--buttonDel")
let closeFormMember = document.querySelector("#inforMember .icon_close")
let btn_add = document.querySelector(".content__header--buttonAdd");
let getInforMember = document.querySelectorAll(".table_wrapper table tbody tr");
let InforMember = document.querySelectorAll("#form-infoMember input")
let search = document.querySelector(".search--input")
let btn_insert = document.querySelector("#inforMember .form-info--button .btn_Insert")
let btn_update = document.querySelector("#inforMember .form-info--button .btn_Update")
let btn_delete = document.querySelector("#inforMember .form-info--button .btn_Delete")
let form_informMember = document.getElementById("inforMember");

const nameMember = document.getElementById("name"); // not number and special character
const emailMember = document.getElementById("email");
const passwordMember = document.getElementById("password"); //< 20 kytu chỉ chứa và có đủ ký tự, ký tự đặc biệt, số
const addressMember = document.getElementById("address"); // không chứa ký tự đặc biệt
const phoneMember = document.getElementById("phonenumber"); // toàn số và phải đủ 10 số
const salaryMember = document.getElementById("salary"); //toàn số
const roleMember = document.getElementById("role");