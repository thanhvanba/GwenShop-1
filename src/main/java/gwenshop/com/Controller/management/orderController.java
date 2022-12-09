package gwenshop.com.Controller.management;

import gwenshop.com.DAO.Order.OrderDAO;
import gwenshop.com.DAO.User.UserDAO;
import gwenshop.com.Entity.Order;
import gwenshop.com.JPAConfig.jpaConfig;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = {"/order", "/order/load-table"})
public class orderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = jpaConfig.getEntityManager();
        if(url.contains("order/load-table"))
        {
            findAll(response, entityManager);
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("/views/admin/order.jsp");
            rq.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public String getStatusOrder(String stt){
        System.out.println(stt);
        if(Objects.equals(stt, "complete")){
            return "" +
                    "<div class=\"status_complete\">\n" +
                    "        <i class=\"fa-solid fa-check check\"></i>\n" +
                    "        Đã hoàn thành\n" +
                    "</div>";
        }
        else if(Objects.equals(stt, "untreated")){
            return "" +
                    "    <div class=\"status_untreated\">\n" +
                    "        <i class=\"fa-solid fa-circle-exclamation error\"></i>\n" +
                    "        Chưa xử lý\n" +
                    "    </div>";
        }
        else {
            return "" +
                    "<div class=\"status_processing\">\n" +
                    "        <i class=\"fa-solid fa-triangle-exclamation warning\"></i>\n" +
                    "        Đang xử lý\n" +
                    "</div>";
        }
    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        OrderDAO orderDAO = new OrderDAO();
        UserDAO userDAO = new UserDAO();
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("" +
                "<thead>\n" +
                "    <tr>\n" +
                "        <th></th>\n" +
                "        <th>ID</th>\n" +
                "        <th>Khách hàng</th>\n" +
                "        <th>Địa chỉ</th>\n" +
                "        <th>Số điện thoại</th>\n" +
                "        <th>Trạng thái</th>\n" +
                "        <th>Người thực hiện</th>\n" +
                "        <th>Tổng tiền</th>\n" +
                "        <th>Ngày tạo</th>        \n" +
                "        <th></th>        \n" +
                "    </tr>\n" +
                "</thead><tbody>");
        List<Order> orders = orderDAO.findAll(entityManager);
        for(Order o: orders){
            out.println("" +
                    "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td>"+o.getId()+"</td>\n" +
                    "<td>"+o.getFullname()+"</td>\n" +
                    "<td>"+o.getAddress()+"</td>\n" +
                    "<td>"+o.getPhonenumber()+"</td>\n" +
                    "<td class=\"\" name = \"status\">\n" +
                        getStatusOrder(o.getStatus()) +
                    "</td>\n" +
                    "<td>"+userDAO.findUser(o.getEmployeeId(), entityManager).getFullname()+"</td>\n" +
                    "<td>"+o.getPrice()+"</td>\n" +
                    "<td>"+o.getCreate_at()+"</td>\n" +
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
                    "</tr>");
        }
        out.println("</tbody>");
    }
}
