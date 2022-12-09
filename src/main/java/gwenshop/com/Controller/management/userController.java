package gwenshop.com.Controller.management;
import gwenshop.com.DAO.User.UserDAO;
import gwenshop.com.Entity.Customer;
import gwenshop.com.Entity.User;
import gwenshop.com.JPAConfig.jpaConfig;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@WebServlet(urlPatterns = {"/employee", "/employee/create", "/employee/delete", "/employee/edit",
"/employee/load-table", "/customer", "/customer/load-table"})
public class userController extends HttpServlet {
    public userController() {
        super();
        // TODO Auto-generated constructor stub
    }
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        EntityManager entityManager = jpaConfig.getEntityManager();
        if(url.contains("customer/load-table")){
            findAllCustomer(resp, entityManager);
        }
        else if (url.contains("employee/load-table")){
            findAll(resp, entityManager);
        }
        else {
            req.getRequestDispatcher("/views/admin/user.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String url = req.getRequestURL().toString();
        EntityManager entityManager = jpaConfig.getEntityManager();
        if (url.contains("create")){
            insert(req,resp);
        }
        else if(url.contains("edit")){
            update(req,resp);
        }
        else if(url.contains("delete")){
            delete(req,resp);
        }
        else if (url.contains("load-table")){
            findAll(resp, entityManager);
        }
        else {
            req.getRequestDispatcher("/views/admin/user.jsp").forward(req,resp);
        }
    }
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String url = req.getRequestURL().toString();
        User user = new User();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        req.setCharacterEncoding("UTF-8");
        try {
            BeanUtils.populate(user, req.getParameterMap());
            if(url.contains("customer")){
                user.setRoles("Khách");
            }
            else if(url.contains("employee")){
                user.setSalary(Integer.parseInt(req.getParameter("salary")));
            }
            user.setCreate_at(dtf.format(now).toString());
            user.setDelete_at(null);
            if(user.getFullname()!=null){
                userDAO.insert(user);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            User user = new User();
            req.setCharacterEncoding("UTF-8");
            BeanUtils.populate(user, req.getParameterMap());
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            user.setCreate_at(dtf.format(now).toString());
            user.setDelete_at(null);
            if(user.getFullname()!=null){
                userDAO.update(user);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp){
        try
        {
            userDAO.delete(Integer.parseInt(req.getParameter("id")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void findAll(HttpServletResponse resp,EntityManager entityManager) throws ServletException, IOException {
        List<User> userList = userDAO.findAll(entityManager);
        resp.setCharacterEncoding("UTF-8");
        String datatable = "";
        for(User u: userList){
            datatable = datatable + "<tr>" +
                    "<td><input type=\"checkbox\"></td>" +
                    "<td>"+u.getId()+"</td>" +
                    "<td>"+u.getFullname()+"</td>" +
                    "<td>"+u.getEmail()+"</td>" +
                    "<td>"+u.getPasswd()+"</td>" +
                    "<td>"+u.getAddr()+"</td>" +
                    "<td>"+u.getPhonenumber()+"</td>" +
                    "<td>"+u.getSalary()+"</td>" +
                    "<td>"+u.getCreate_at()+"</td>" +
                    "<td>"+u.getDelete_at()+"</td>" +
                    "</tr>";
        }
        PrintWriter out = resp.getWriter();
        out.println(
                "<thead>\n" +
                        "   <tr>\n" +
                        "       <th></th>\n" +
                        "       <th>ID</th>\n" +
                        "       <th>Họ và tên</th>\n" +
                        "       <th>Email</th>\n" +
                        "       <th>Mật khẩu</th>\n" +
                        "       <th>Địa chỉ</th>\n" +
                        "       <th>Số điện thoại</th>\n" +
                        "       <th>Lương</th>\n" +
                        "       <th>Ngày tạo</th>\n" +
                        "       <th>Ngày xóa</th>\n" +
                        "   </tr>\n" +
                        "</thead>\n" +
                        "  <tbody>" +
                        datatable +
                        "</tbody>"
        );
    }
    private void findAllCustomer(HttpServletResponse resp, EntityManager entityManager) throws ServletException, IOException {
        UserDAO customer = new UserDAO();
        List<Customer> customers = customer.findAllCustomer(entityManager);
        resp.setCharacterEncoding("UTF-8");
        String datatable = "";
        for(Customer c: customers){
             datatable = datatable + "<tr>" +
                            " <td><input type=\"checkbox\"></td>" +
                            "<td>"+c.getId()+"</td>" +
                            "<td>"+c.getFullname()+"</td>" +
                            "<td>"+c.getEmail()+"</td>" +
                            "<td>"+c.getPasswd()+"</td>" +
                            "<td>"+c.getAddr()+"</td>" +
                            "<td>"+c.getPhonenumber()+"</td>" +
                            "<td>"+c.getCreate_at()+"</td>" +
                            "<td>"+c.getDelete_at()+"</td>" +
                        "</tr>";
        }
        PrintWriter out = resp.getWriter();
        out.println(
                "<thead>\n" +
                        "   <tr>\n" +
                        "       <th></th>\n" +
                        "       <th>ID</th>\n" +
                        "       <th>Họ và tên</th>\n" +
                        "       <th>Email</th>\n" +
                        "       <th>Mật khẩu</th>\n" +
                        "       <th>Địa chỉ</th>\n" +
                        "       <th>Số điện thoại</th>\n" +
                        "       <th>Ngày tạo</th>\n" +
                        "       <th>Ngày xóa</th>\n" +
                        "   </tr>\n" +
                        "</thead>\n" +
                        "  <tbody>" +
                        datatable +
                        "</tbody>"
        );
    }
}

