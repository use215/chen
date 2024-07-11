package cn.edu.lingnan.servlet;

//import cn.edu.lingnan.pojo.User;
//import cn.edu.lingnan.service.UserServiceMysqllmpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//

import cn.edu.lingnan.pojo.User;
import cn.edu.lingnan.service.UserServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/admin/updateStu")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        int right = Integer.parseInt(req.getParameter("right"));
        System.out.println("[Debug 080]" + id + "   " + name + "   " + password + "   " + phone + "   " + right);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRight(right);
        //2
        UserServiceMysqlImpl service = new UserServiceMysqlImpl();
        int flag = service.updateUser(user);
        //3
        resp.sendRedirect("/queryAllStu");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
