package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.User;
import cn.edu.lingnan.service.UserServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/inserStu")
public class InsertUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        System.out.println("[Debug 080]" + id + "   " + name + "   " + password);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRight(1);
        //2
        UserServiceMysqlImpl service = new UserServiceMysqlImpl();
        int flag = service.insertUser(user);
        //3
        resp.sendRedirect(req.getContextPath()+"/index.html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
