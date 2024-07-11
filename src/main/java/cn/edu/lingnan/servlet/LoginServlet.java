package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.User;
import cn.edu.lingnan.service.UserServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1 从页面读取表单传递过来的参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");


        //建议刚开始练习时，写一个输出，测试一下是否真的拿到数据
        System.out.println("[Debug]name and password is " + name + " " + password);
        //2 调用业务逻辑类，进而调用Dao类，访问数据库
        UserServiceMysqlImpl service = new UserServiceMysqlImpl();
        User user = service.findUserByNameAndPassword(name, password);
        //拿到返回结果之后再存储相应的值
        HttpSession session = req.getSession();
        session.setAttribute("right", user.getRight());//存储用户权限是1||0
        if (user.getRight()==1) {
            session.setAttribute("name","管理员");
        }else
            session.setAttribute("name","游客");

        //建议刚开始练习时，写一个输出，测试一下是否真的拿到返回数据
//        System.out.println("[Debug] the value of flag is " + flag);
        //3 依据返回值，去到相应的页面
        if (user.getId() != null)
            resp.sendRedirect("/main.jsp");
        else
            resp.sendRedirect("/error.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
