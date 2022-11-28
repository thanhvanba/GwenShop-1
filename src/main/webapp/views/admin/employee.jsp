<%--
  Created by IntelliJ IDEA.
  User: PhucPhuc
  Date: 11/9/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/public/css/management/base.css">
    <link rel="stylesheet" href="views/public/css/management/header.css">
    <link rel="stylesheet" href="views/public/css/management/content.css">
    <link rel="stylesheet" href="views/public/css/management/user/content.css">
    <link rel="stylesheet" href="views/public/css/management/sidebar.css">
    <link rel="stylesheet" href="views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <title>GwenShop</title>
</head>
<body>
<div id="header">
    <div class="header__wrap">
        <div class="header__item-left">
            <div id="guide-button">
                <div></div>
                <div></div>
                <div></div>
            </div>
            <div id="logoweb">
                <span>Admin</span>
            </div>
        </div>
        <div class="header__avata-user"></div>
    </div>
</div>
<div id="web_body">
    <div id="sidebar">
        <ul class="sidebar_items">
            <a href="employee" class="sidebar_item">
                <li>
                    <img src="views/public/icon/icon_user.png" class = "sidebar_item-icon" id="employee" alt="">
                    Nhân viên
                </li>
            </a>
            <a href="customer" class="sidebar_item">
                <li>
                    <img src="views/public/icon/icon_buyer.png" class = "sidebar_item-icon" alt="">
                    Khách hàng
                </li>
            </a>
            <a href="category" class="sidebar_item">
                <li>
                    <img src="views/public/icon/icon_category.png" class = "sidebar_item-icon" alt="">
                    Danh mục
                </li>
            </a>
            <a href="product" class="sidebar_item">
                <li>
                    <img src="views/public/icon/icon_product.png" class = "sidebar_item-icon" alt="">
                    Sản phẩm
                </li>
            </a>
            <a href="order.html" class="sidebar_item">
                <li>
                    <img src="views/public/icon/icon_order.png" class = "sidebar_item-icon" alt="">
                    Đơn hàng
                </li>
            </a>
        </ul>
    </div>
    <div class="content__wrapper">
        <div class="content">
            <div class="content__header">
                <div>
                    <div class="search">
                        <input class="search--input" type="text" onkeypress="checkEnterClick(event)" placeholder="Nhập tên hoặc ID">
                    </div>
                    <img src="views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                </div>
                <img src="views/public/icon/icon_wastebasket.png" class="content__header--buttonDel" alt="">
            </div>
            <div class="table_wrapper">
                <table class="table_employee">
                    <thead></thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="layer"></div>
    <div id = "inforMember">
        <img src="views/public/icon/icon_close.png" class="icon_close" alt="">
        <form action="" method="POST" class="form" id="form-infoMember">
            <h3 class="heading">Thông tin User</h3>
            <div class="spacer"></div>
            <div class="" style="display: flex; justify-content: space-between;">
                <div class="form-group">
                    <label for="fullname" class="form-label">Tên đầy đủ</label>
                    <input id="fullname" name="fullname" type="text" placeholder="VD: Nguyễn Văn A" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phonenumber" class="form-label">Số điện thoại</label>
                    <input id="phonenumber" name="phonenumber" placeholder="Nhập số điện thoại" type="text" class="form-control">
                    <span class="form-message"></span>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input id="email" name="email" type="text" placeholder="VD: email@domain.com" class="form-control">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="password" class="form-label">Mật khẩu</label>
                <input id="password" name="password" type="text" placeholder="Nhập mật khẩu" class="form-control">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="address" class="form-label">Địa chỉ</label>
                <input id="address" name="address" placeholder="Nhập địa chỉ" type="text" class="form-control">
                <span class="form-message"></span>
            </div>
            <div class="" style="display: flex;">
                <div class="form-group">
                    <label for="salary" class="form-label">Lương</label>
                    <input id="salary" name="salary" placeholder="Nhập mức lương" type="text" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="role" class="form-label">Chức vụ</label>
                    <select id="role" name="role">
                        <option value="Nhân viên">Nhân viên</option>
                        <option value="Quản lý">Quản lý</option>
                    </select>
                </div>
            </div>
            <div class="form-info--button">
                <button class="btn_Delete">Xóa</button>
                <button class="btn_Update">Cập nhật</button>
                <button class="btn_Insert">Thêm</button>
            </div>
        </form>
    </div>
</div>
<div id="toast"></div>
<script src="views/public/js/UserManagement/getElement.js"></script>
<script src="views/public/js/UserManagement/employee.js"></script>
<script src="views/public/js/main.js"></script>
<script src="views/public/js/UserManagement/checkInfo.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        Validator({
            form: '#form-infoMember',
            formGroupSelector: '.form-group',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired(document.getElementById('fullname'),  'Tên không chứa ký tự đăc biệt và số'),
                Validator.isEmail(document.getElementById('email'), 'Nhập lại địa chỉ email'),
                Validator.minLength(document.getElementById('password'), 8, 15),
                Validator.isPhoneNumber(document.getElementById('phonenumber'), 'phải đủ 10 số'),
                Validator.isAddress(document.getElementById('address'),'nhập lại địa chỉ'),
                Validator.isSalary(document.getElementById('salary'), 'nhập lại mức lương')
            ],
            onSubmit: function (data) {
                console.log(data);
            }
        });
    });
</script>
</body>
</html>