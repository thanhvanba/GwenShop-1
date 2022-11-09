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
    <link rel="stylesheet" href="/assets/css/base.css">
    <link rel="stylesheet" href="/assets/css/content.css">
    <link rel="stylesheet" href="/assets/css/sidebar.css">
    <title>GwenShop</title>
</head>
<body>
<div class="web_body">
    <div class="sidebar">
        <a href="#">
            <div class="weblogo"></div>
        </a>
        <ul class="category">
            <li>
                <img src="/assets/icon/icon_user.png" class = "category__icon" alt="">
                Nhân viên
            </li>
            <li>
                <img src="/assets/icon/icon_buyer.png" class = "category__icon" alt="">
                Khách hàng
            </li>
            <li>
                <img src="/assets/icon/icon_category.png" class = "category__icon" alt="">
                Danh mục
            </li>
            <li>
                <img src="/assets/icon/icon_product.png" class = "category__icon" alt="">
                Sản phẩm
            </li>
            <li>
                <img src="/assets/icon/icon_order.png" class = "category__icon" alt="">
                Đơn hàng
            </li>
        </ul>
    </div>
    <div class="content__wrapper">
        <div class="content">
            <div class="content__header">
                <div>
                    <div class="search">
                        <input class="search--input" type="text" placeholder="Nhập tên hoặc ID">
                    </div>
                    <img src="/assets/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                </div>
                <img src="/assets/icon/icon_wastebasket.png" class="content__header--buttonDel" alt="">
            </div>
            <div class="table_wrapper">
                <table class="table_employee">
                    <thead></thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="layer">
        <div id = "inforMember">
            <img src="/assets/icon/icon_close.png" class="icon_close" alt="">
            <div class="form-info">
                <table>
                    <tr>
                        <td><span>Tên</span></td>
                        <td><input type="text" value="Trịnh Hoàng Phúc"></td>
                    </tr>
                    <tr>
                        <td><span>Email</span></td>
                        <td><input type="text" value="hoangphuc01022002@gmail.com"></td>
                    </tr>
                    <tr>
                        <td><span>Password</span></td>
                        <td><input type="text" value="phuc0201"></td>
                    </tr>
                    <tr>
                        <td><span>Địa chỉ</span></td>
                        <td><input type="text" value="An Giang"></td>
                    </tr>
                    <tr>
                        <td><span>Số điện thoại</span></td>
                        <td><input type="text" value="0987654321"></td>
                    </tr>
                    <tr>
                        <td><span>Lương</span></td>
                        <td><input type="text" value="50000000"></td>

                    </tr>
                    <tr>
                        <td><span>Chức vụ</span></td>
                        <td><input type="text" value="Quản lý"></td>
                    </tr>
                </table>
            </div>
            <div class="form-info--button">
                <button class="btn_Update">Cập nhật</button>
                <button class="btn_Delete">Xóa</button>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/script.js"></script>
</body>
</html>
