package gwenshop.com.Controller.management;

import gwenshop.com.DAO.Product.ProductDAO;
import gwenshop.com.Entity.Product;
import gwenshop.com.JPAConfig.jpaConfig;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/product", "/product/load-table"})
public class productController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = jpaConfig.getEntityManager();
        if(url.contains("product/load-table")){
            findAll(response, entityManager);
        }
        else {
            request.getRequestDispatcher("/views/admin/product.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        response.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.findAll(entityManager);
        String header_table = "<thead>"+"<tr>\n" +
                "    <th></th>\n" +
                "    <th>ID</th>\n" +
                "    <th>Ảnh</th>\n" +
                "    <th>Tên sản phẩm</th>\n" +
                "    <th>Mô tả</th>\n" +
                "    <th>Số lượng</th>\n" +
                "    <th>Giá</th>\n" +
                "    <th></th>\n" +
                "</tr>" + "</thead>";
        String data_table = "";
        PrintWriter out = response.getWriter();
        out.println(header_table + "<tbody>");
        for(Product p: products){
            data_table = "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td class=\"col__id-product\">"+p.getId()+"</td>\n" +
                    "<td class=\"col__product-image\">\n" +
                    "    <div class=\"product-image\" style=\"background-image: url('"+productDAO.findProductImages(p.getId(), entityManager).get(0).getImage()+"');\">\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "<td class=\"col__product-name\">"+p.getName()+"</td>\n" +
                    "<td class=\"col__product-description\">\n" +
                    "    <textarea readonly class=\"product-description\">"+p.getDescription()+"</textarea>\n" +
                    "</td>\n" +
                    "<td class=\"col__amount\">"+p.getAmount()+"</td>\n" +
                    "<td class=\"col__price\">"+p.getPrice()+"</td>\n" +
                    "<td>\n" +
                    "    <div class=\"\" style=\"display: flex; align-items: center;\">\n" +
                    "        <button class=\"btn_Edit\">\n" +
                    "            <i class=\"fa-solid fa-pen-to-square\" style=\"color: white;\"></i>\n" +
                    "        </button>\n" +
                    "        <button class=\"btn_Delete\">\n" +
                    "            <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "</tr>";
            out.println(data_table);
        }
        out.println("</tbody>");
    };
}
