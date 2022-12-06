
let product_des = `
MÔ TẢ SẢN PHẨM
Áo khoác gió cho bé trai bé gái chống nước cản gió hiệu quả
⭐ THÔNG TIN SẢN PHẨM:
Chất vải áo gió cho bé là polyester loại 1 mềm mịn đẹp, bao giặt máy không bị ra màu
Hàng đẹp cho các bạn mua cho bé mặc trong mùa mưa sài gòn và thu đông ở Ngoài Bắc là rất hợp lý
Siêu gọn, nhẹ, không nhăn, không lo bị bí nóng.
Bảo vệ cho bé an toàn tránh khỏi mưa nhẹ, gió rét và bụi
Thiết kế lớp gió bên ngoài mềm mại và lớp lưới bên trong, 2 túi ngoài có khóa kéo, túi trước ngực thời trang, túi ngực trong tiện lợi
Bảng chọn Size chuẩn cho bé:
Size 6-7: 15-21kg; chiều cao bé từ 1m1-1m2
Size 8-9: 22-27kg; chiều cao bé từ 1m2-1m3
Size 10-11: 28-34kg; chiều cao bé từ 1m3-1m39
Size 12-13: 35-43kg; chiều cao bé từ 1m4-1m50
Size 13-14: 44-55kg; chiều cao bé dưới 1m6
Với những trường hợp khác, anh chị vui lòng inbox trực tiếp cho shop để shop tư vấn cho mình nhé!!!
============================
⭐ HƯỚNG DẪN CÁCH ĐẶT HÀNG:
✅ Cách chọn Size: Shop đã phân bảng Size, bảng Màu. Bạn nên Inbox Shop, cung cấp Chiều cao và Cân nặng để shop tư vấn cho phù hợp!
✅ Cách đặt hàng qua Shopee:
Nếu mua 1 sản phẩm thì bạn chọn Màu rồi ấn MUA HÀNG. Nếu bạn muốn mua 2-3 Sản phẩm khác nhau hoặc 2-3 màu khác nhau để được Freeship:
+ Bạn chọn từng Sản phẩm rồi thêm vào Giỏ hàng.
+ Khi Giỏ Hàng đã có đầy đủ các Sản phẩm cần Mua, bạn mới tiến hành "Thanh toán".
🛑 LƯU Ý:
📌 Quý Khách vui lòng đọc kỹ Thông Tin Sản Phẩm trước khi đặt hàng, tránh đặt rồi hủy hàng nhé, hoặc có hủy thì hủy sớm trước khi đơn hàng đưa vận chuyển nhé. Vì sau khi đặt hàng, hàng sẽ được Shop gói và gửi đi liền trong ngày hoặc ngày hôm sau. Vì thế việc hủy hàng sẽ gây nhiều khó khăn cho Shop. Rất mong Quý Khách cảm thông và đắn đo giúp Shop!!!
📌 Theo quy định của Shopee Khách hàng sẽ KHÔNG ĐƯỢC XEM HÀNG trước khi thanh toán nhưng được đổi trả sau 24h nếu sản phẩm bị lỗi tính từ thời điểm nhận được hàng. Hãy chắc chắn nhận hàng và để thông tin chính xác khi ấn Mua hàng tránh trường hợp giao đi rồi lại quay về.
📌 Hàng sẽ được Shop giao cho vận chuyển trong 1 ngày kể từ khi đặt hàng. Vì vậy, nếu có yêu cầu hủy đơn hàng vui lòng inbox Shop và quyết định trước khi shop giao cho vận chuyển. Vận chuyển của Shopee sẽ liên hệ quý khách để giao hàng. (Nội thành HN 1-2 ngày, Ngoại thành và các Tỉnh TP khác 3-5 ngày)
#ao #khoac #gio #cho #be #betrai #begai #chong #nuoc #cangio #amap #cute #2lop #lot #luoi #co #mu #thoi #trang #cao #cap #dep #aokhoac #aogio #aogiotrecon #aogiochobe #aokhoacbe #aokhoactrecon #aokhoacdu #aokhoacchobenam #aokhoacchobenu #aokhoacnhe
`
description.innerHTML = product_des;

// MAIN //
product_control();
function product_control()
{
    getElement();
    checkInfoInput();
    if(list_image.length == 1)
        showImage.style.backgroundImage = null;

    btn_Delete.forEach((del)=>{
        del.onclick = ()=>{
            showSuccessToast('xóa');
        }
    })

    for(let img = 0; img < image_item.length - 1; img ++){
        image_item[img].onclick = ()=>{
            showImage.style.backgroundImage = image_item[img].style.backgroundImage;
        }
    }

    btn_add.onclick=()=>{
        showFormInfoProduct();
        btn_update.style.display = "none";
        btn_insert.style.display = "block";
    };
    btn_Edit.forEach((edit)=>{
        edit.onclick = ()=>{
            showFormInfoProduct();
            btn_insert.style.display = "none";
            btn_update.style.display = "block";
        };
    })
    function showFormInfoProduct(){
        resetInputForm(form_infoProduct);
        let layer = document.createElement("div");
        layer.className = "layer";
        document.querySelector("body").appendChild(layer);

        layer.addEventListener("click", ()=>{
            form_infoProduct.style.display = "none";
            layer.remove();
        })
        form_infoProduct.style.display = "block";
    }
    function resetInputForm(element)
    {
        element.querySelectorAll('input').forEach((input)=>{
            input.value = "";
            input.parentElement.classList.remove("invalid");
        })
        element.querySelectorAll('.form-message').forEach((message)=>{
            message.innerHTML = "";
        })
        for(let img = 0; img < list_image.length - 1; img++){
            list_image[img].remove();
        }
        showImage.style.backgroundImage = null;
    }
    icon_minus.forEach((elm)=>{
        elm.onclick = ()=>{
            let elmPar = elm.parentElement;
            elm.parentElement.remove();
            getElement();
            if(elmPar.lastChild.style.backgroundImage == showImage.style.backgroundImage)
            {
                if(list_image.length == 1)
                    showImage.style.backgroundImage = null;
                else
                    showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
            }
            if(elmPar.className == list_image[0].className)
            {
                product_control();
                plusImages(-1);
            }
        }
    })
}

let slideImageIndex = 0;

function plusImages(firstImage) {
    showSlideImage(slideImageIndex += firstImage);
}
function currentImage(currImage) {
    showImage.style.backgroundImage = list_image[currImage].style.backgroundImage;
}
function showSlideImage(images)
{
    if(list_image.length >= 5)
    {
        if (images < 0) {slideImageIndex = 0}
        if (images > list_image.length - 5) {slideImageIndex = list_image.length - 5;}
        for(let i = slideImageIndex; i < slideImageIndex + 5; i++)
            list_image[i].style.display = "block";
        for(let i = slideImageIndex + 5; i < list_image.length; i++)
            list_image[i].style.display = "none";
        for(let i = slideImageIndex - 1; i >= 0; i--)
            list_image[i].style.display = "none";
    }
}



addColor.addEventListener("click", ()=>{
    let section = document.createElement("section")
    section.innerHTML=`
    <input type="text" class="item-color" value="" placeholder="Nhập tên màu"></input>
    <i class="fa-solid fa-circle-minus icon-minus"></i>
    <span class="form-message"></span>
  `
    listColor.appendChild(section)
    product_control();
})


addSize.addEventListener("click", ()=>{
    let section = document.createElement("section")
    section.innerHTML=`
    <input type="text" class="item-size" value="" placeholder="Nhập size"></input>
    <i class="fa-solid fa-circle-minus icon-minus"></i>  
    <span class="form-message"></span>
  `
    listSize.appendChild(section)
    product_control();
})

addNewImage.addEventListener("click", ()=>{
    importImage();
})

function importImage() {
    let fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.setAttribute("multiple", "multiple")
    fileInput.click();
    fileInput.onchange = ()=> {
        if (fileInput.multiple)
        {
            for (let file of fileInput.files) {
                setImage(file);
            }
        }
        else{
            setImage(fileInput.files[0])
        }
    };
}
function setImage(file){
    let wrapper = document.createElement("div");
    let img = document.createElement("div");
    let iconRemove = document.createElement("i");
    iconRemove.className="fa-solid fa-circle-minus icon-minus";
    wrapper.className = "image-item_wrapper";
    img.className = "image-item";
    wrapper.appendChild(iconRemove);
    wrapper.appendChild(img);
    list_image_wrap.insertBefore(wrapper, list_image[list_image.length-1]);
    img.style.backgroundImage = `url(${URL.createObjectURL(file)})`;
    product_control();
    showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
    plusImages(1);
}
