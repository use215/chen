package cn.edu.lingnan.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthorityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //判断用户权限是否为管理员，如果是管理员，则可以访问相应的页面，如果不是管理员，则可返回特定的页面
        //如果是管理员，则可以访问admin/admin.jsp，如果不是，则返回一个特定的界面
        //前提：我必须拿到用户权限
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        Integer right = (Integer)session.getAttribute("right");
        //System.out.println("[Debug 020] the studnet's right is" + " "+right);
        //phone 可能取什么值：1 0 null

        //这里本来是什么
        if(right!=null){//有登录的情况
            if(right==1){//管理员登录情况
                chain.doFilter(request,response);
            }else{//普通用户登录情况
                resp.sendRedirect(req.getContextPath()+"/authority.html");
            }
        }else {
            //没有登录的情况
            resp.sendRedirect(req.getContextPath()+"/index.html");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
