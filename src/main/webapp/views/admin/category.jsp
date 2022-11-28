<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="views/public/css/management/base.css">
    <link rel="stylesheet" href="views/public/css/management/header.css">
    <link rel="stylesheet" href="views/public/css/management/content.css">
    <link rel="stylesheet" href="views/public/css/management/sidebar.css">
    <link rel="stylesheet" href="views/public/css/management/category/content.css">
    <title>category</title>
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
        <div class="header__avata-user">

        </div>
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
            <a href="customer.html" class="sidebar_item">
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
                <section>
                    <input class="search--input" type="text" placeholder="Tìm kiếm">
                    <div class="insert_category">
                        <input class="insert_category-input" type="text" placeholder="Nhập tên danh mục">
                        <span class="message"></span>
                        <img src="views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                    </div>
                </section>
            </div>
            <div class="table_wrapper">
                <table class="table_category">
                    <thead>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div id="toast"></div>
<script src="views/public/js/CategoryManagement/getElement.js"></script>
<script src="views/public/js/main.js"></script>
<script src="views/public/js/CategoryManagement/checkInfo.js"></script>
<script src="views/public/js/CategoryManagement/category.js"></script>
</body>
</html>


