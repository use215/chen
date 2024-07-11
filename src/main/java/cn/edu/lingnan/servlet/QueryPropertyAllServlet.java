package cn.edu.lingnan.servlet;

import cn.edu.lingnan.pojo.Property;
import cn.edu.lingnan.service.PropertyServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/queryAllRace")
public class QueryPropertyAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1
        //2
        PropertyServiceMysqlImpl service = new PropertyServiceMysqlImpl();

        List<Property> list = service.findPropertyAll();
        HttpSession session = req.getSession();
        session.setAttribute("allRace",list);
        //3
        resp.sendRedirect(req.getContextPath()+"/admin/raceadmin.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);

    }
}
