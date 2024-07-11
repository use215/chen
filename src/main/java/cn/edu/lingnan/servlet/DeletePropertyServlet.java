package cn.edu.lingnan.servlet;

import cn.edu.lingnan.service.PropertyServiceMysqlImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/admin/delCom")
public class DeletePropertyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1
        String pid = req.getParameter("pid");
        String flag=req.getParameter("flag");
        System.out.println("[Debug 059] the flag's value is " + flag);
        System.out.println("[Debug 060] the cid's value is " + pid);
        //2
        PropertyServiceMysqlImpl service = new PropertyServiceMysqlImpl();

        if (flag != null) {//这里删除多个记录
            String[] allpid = pid.split(",");
            for (String onepid : allpid) {
                service.deletePropertyByPid(onepid);
            }
        }else {//这里删除单个记录
            service.deletePropertyByPid(pid);
        }
        //3
        resp.sendRedirect("/queryAllRace");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
