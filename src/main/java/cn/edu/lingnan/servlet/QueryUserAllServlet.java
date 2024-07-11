package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.User;
import cn.edu.lingnan.service.UserServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/queryAllStu")
public class QueryUserAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceMysqlImpl service = new UserServiceMysqlImpl();
        List<User> list = service.findUserAll();
        HttpSession session = req.getSession();
        session.setAttribute("allStu",list);
        resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
