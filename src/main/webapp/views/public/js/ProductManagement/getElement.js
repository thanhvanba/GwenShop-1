let tableThead = document.querySelector(".table_wrapper .table_product thead")
let tableBody = document.querySelector(".table_wrapper .table_product tbody")
tableThead.innerHTML = `
<tr>
    <th></th>
    <th>ID</th>
    <th>Image</th>
    <th>Name</th>
    <th>Description</th>
    <th>Amount</th>
    <th>Price</th>        
    <th></th>        
</tr>
`
for(let i = 0; i<100; i++)
{
    tableBody.innerHTML += ` <tr>
                                <td>
                                    <input type="checkbox">
                                </td>
                                <td class="col__id-product">${i+1}</td>
                                <td class="col__product-image">
                                    <div class="product-image" style="background-image: url('https://i.ibb.co/jzKT9CD/1.png');">

                                    </div>
                                </td>
                                <td class="col__product-name">Áo vest</td>
                                <td class="col__product-description">
                                    <textarea readonly class="product-description">ascdccds</textarea>
                                </td>
                                <td class="col__amount">100</td>
                                <td class="col__price">1000000</td>
                                <td>
                                    <div class="" style="display: flex; align-items: center;">
                                        <button class="btn_Edit">
                                            <i class="fa-solid fa-pen-to-square" style="color: white;"></i>
                                        </button>
                                        <button class="btn_Delete">
                                            <i class="fa-solid fa-trash-can" style="color: red;"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>`
}
function getElement(){
    icon_wastebasket = document.querySelector(".content__header--buttonDel")
    btn_add = document.querySelector(".content__header--buttonAdd");
    checkbox_wastebasket = document.querySelectorAll(".table_wrapper input")
    btn_Delete = document.querySelectorAll(".table_product .btn_Delete")
    btn_Edit = document.querySelectorAll(".table_product .btn_Edit")
    list_image_wrap = document.querySelector("#form-inforProduct__image .list-image")
    list_image = document.querySelectorAll("#form-inforProduct__image .list-image .image-item_wrapper")
    image_item = document.querySelectorAll("#form-inforProduct__image .list-image .image-item")
    showImage = document.querySelector("#form-inforProduct__image .main-image")
    form_infoProduct = document.getElementById("form-inforProduct")
    addColor = document.querySelector("#form-inforProduct__infor #product_color .icon-plus")
    icon_minus = document.querySelectorAll(".icon-minus")
    addSize = document.querySelector("#form-inforProduct__infor #product_size .icon-plus")
    description = document.getElementById("form-inforProduct__description");
    listColor = document.querySelector("#form-inforProduct__infor #product_color .list-color")
    listSize = document.querySelector("#form-inforProduct__infor #product_size .list-size")
    addNewImage = document.querySelector("#form-inforProduct__image .list-image .addImage")
    btn_insert = document.querySelector("#form-inforProduct__infor .button-insert");
    btn_update = document.querySelector("#form-inforProduct__infor .button-update");
}
getElement()
