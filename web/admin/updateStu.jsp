<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.User" %>
<%@ page import="cn.edu.lingnan.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: wjy
  Date: 2024/4/25
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--  <script type="text/javascript"  src="../js/admin.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="../css/1.css">

</head>
<body>
<h1 align="center">管理员页面--更新页面</h1>
<hr>
<br>
<form action="updateStu">
    <table>
        <caption>所有用户信息</caption>
        <thead>
        <tr>
            <%--    <td><input type="checkbox" onclick="allcheck(this);"></td>--%>
            <td>用户编号</td>
            <td>用户姓名</td>
            <td>用户密码</td>
            <td>用户电话</td>
            <td>用户权限</td>
            <td>选择操作</td>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> allStu = (List<User>) session.getAttribute("allStu");

            String id = request.getParameter("id");

            for (User user : allStu) {
                if (user.getId().equals(id)) {


        %>
        <tr>
            <%--    <td><input type="checkbox" name="check" value="<%=user.getId()%>"></td>--%>
            <td><input type="hidden" name="id" value="<%=user.getId()%>"><%=user.getId()%>
            </td>
            <td><input type="text" name="name" value="<%=user.getName()%>">
            </td>
            <td><input type="text" name="password" value="<%=user.getPassword()%>">
            </td>
            <td><input type="text" name="phone" value="<%=user.getPhone()%>">
            </td>
            <td><input type="text" name="right" value="<%=user.getRight()%>">
            </td>
            <td>
                <input type="submit" value="确认修改"/>
            </td>
        </tr>
        <%
                }
            }
        %>

        </tbody>

        <tfoot>
        <tr>
            <td colspan="7"></td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>
