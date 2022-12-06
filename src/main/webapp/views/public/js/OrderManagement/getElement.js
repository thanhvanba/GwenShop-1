let tableThead = document.querySelector(".table_wrapper .table_order thead")
let tableBody = document.querySelector(".table_wrapper .table_order tbody")
tableThead.innerHTML = `
<tr>
    <th></th>
    <th>ID</th>
    <th>Khách hàng</th>
    <th>Địa chỉ</th>
    <th>Số điện thoại</th>
    <th>Trạng thái</th>
    <th>Người thực hiện</th>
    <th>Tổng tiền</th>
    <th>Ngày tạo</th>        
    <th></th>        
</tr>
`
let arr_status = [
    `
    <div class="status_complete">
        <i class="fa-solid fa-check check"></i>
        Đã hoàn thành
    </div>`,
    `
    <div class="status_untreated">
        <i class="fa-solid fa-circle-exclamation error"></i>
        Chưa xử lý
    </div>
    `,
    ` <div class="status_processing">
        <i class="fa-solid fa-triangle-exclamation warning"></i>
        Đang xử lý
    </div>`
]
for(let i = 0; i<100; i++)
{
    tableBody.innerHTML += `<tr>
                                <td>
                                    <input type="checkbox">
                                </td>
                                <td class="" name = "id">${i+1}</td>
                                <td class="" name = "customer_name">Trịnh Hoàng Phúc ${i+1}</td>
                                <td class="" name = "address">An Giang</td>
                                <td class="" name = "phonenumber">0987654321</td>
                                <td class="" name = "status">
                                    ${arr_status[i%3]}                    
                                </td>
                                <td class="" name = "employee">Nguyễn Bá Phước</td>
                                <td class="" name = "total_price">1000000</td>
                                <td class="" name = "create_at">11-2-2022</td>
                                <td class="" name ="">
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
function getElement() {
}
getElement()

