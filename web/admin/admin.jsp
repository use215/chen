<%@ page import="cn.edu.lingnan.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/race01.css">
    <script type="text/javascript" src="../js/admin.js"></script>
</head>
<body>
<h1 align="center">用户管理页面</h1>
<hr><br>
<table class="pure-table">
    <thead>
    <tr>
        <td><input type = "checkbox" name="check" onclick="allcheck(this);"></td>
        <td>用户编号</td>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>用户电话</td>
        <td>用户权限</td>
        <td><input type="submit" value="批量删除" onclick="delcheck();"></td>
    </tr>
    </thead>
    <%
        List<User> allStu = (List<User>)session.getAttribute("allStu");
        for (User user : allStu) {
    %>
    <tr>
        <td><input name="check" type="checkbox" value="<%=user.getId()%>"></td>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getPhone()%></td>
        <td><%=user.getRight()%></td>
        <td>
            <a href="updateStu.jsp?id=<%=user.getId()%>">修改</a> |
            <a href="delStu?id=<%=user.getId()%>">删除</a>
        </td>
    </tr>

    <%
        }
    %>
    <a href="../main.jsp">返回</a>
</table>
</body>
</html>
