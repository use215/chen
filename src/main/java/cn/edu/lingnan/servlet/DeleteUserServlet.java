package cn.edu.lingnan.servlet;

import cn.edu.lingnan.service.UserServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/delStu")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1
        String id = req.getParameter("id");
        String flag = req.getParameter("flag");
        //System.out.println("[Debug 060] the id's value is  " + id);
        //2
        UserServiceMysqlImpl service = new UserServiceMysqlImpl();
        if (flag != null)
        {
            String[] allid = id.split(",");
            for(String oneid : allid){
               // System.out.println("[Debug 061] the del_id value is  " + oneid);//不是id
                service.deleteUserById(oneid);
            }

        }else{
            service.deleteUserById(id);
        }
        //3从一个servlet跳到另一个servlt
        resp.sendRedirect("/queryAllStu");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
