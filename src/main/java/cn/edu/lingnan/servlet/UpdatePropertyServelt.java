package cn.edu.lingnan.servlet;


import cn.edu.lingnan.pojo.Property;
import cn.edu.lingnan.service.PropertyServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/admin/updateRace")
public class UpdatePropertyServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1
        String pid = req.getParameter("pid");
        String address = req.getParameter("address");
        int price = Integer.parseInt(req.getParameter("price"));
        int area = Integer.parseInt(req.getParameter("area"));
        String type = req.getParameter("type");
        System.out.println("[Debug 080]" + pid + "   " + address + "   " + area + "   " + price);
        Property property = new Property();
        property.setPid(pid);
        property.setAddress(address);
        property.setPrice(price);
        property.setArea(area);
        property.setType(type);
        //2
        PropertyServiceMysqlImpl service = new PropertyServiceMysqlImpl();

        int flag = service.updateProperty(property);
        System.out.println("1111111111111111"+flag);
        //3
        resp.sendRedirect("/queryAllRace");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}

