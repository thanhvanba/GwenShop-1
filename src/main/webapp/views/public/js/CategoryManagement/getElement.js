let tableThead = document.querySelector(".table_wrapper .table_category thead")
let tableBody = document.querySelector(".table_wrapper .table_category tbody")
tableThead.innerHTML = `
<tr>
    <th></th>
    <th>ID</th>
    <th>Danh mục</th>
    <th>Tổng sản phẩm</th>     
    <th></th>        
</tr>
`
for(let i = 0; i<100; i++)
{
    tableBody.innerHTML += ` <tr>
                                <td>
                                    <input type="checkbox">
                                </td>
                                <td class="col__id-category">${i+1}</td>
                                <td class="col__category-name">Unisex</td>           
                                <td class="col__category-productAmount">12132</td> 
                                <td>
                                    <button class="btn_Edit">
                                            <i class="fa-solid fa-pen-to-square" style="color: white;"></i>
                                    </button>
                                    <button class="btn_Delete">
                                        <i class="fa-solid fa-trash-can" style="color: red;"></i>
                                    </button>
                                </td>                      
                            </tr>`
}
function getElement(){
    table_category_thead = document.querySelectorAll('.table_category th');
    table_category = document.querySelectorAll('.table_category');
    btn_Delete = document.querySelectorAll(".table_category .btn_Delete")
    btn_Edit = document.querySelectorAll(".table_category .btn_Edit")
}