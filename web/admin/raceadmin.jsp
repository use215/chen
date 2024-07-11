<%@ page import="cn.edu.lingnan.pojo.Property" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/race01.css">
    <script type="text/javascript" src="../js/admin.js"></script>

</head>
<body>
<h1 align="center">房源管理页面</h1>
<hr><br>注销<br><hr>
<table>
    <tr>
        <td><input type="checkbox" onclick="allcheck(this);"></td>
        <td>房源编号</td>
        <td>房源地址</td>
        <td>价格</td>
        <td>面积</td>
        <td>房源类型</td>
        <td>
            <input type="submit" value="批量删除" onclick="Rdelcheck();">
        </td>
        <%-- <td><input type="submit" value="批量删除" onclick="delcheck();"></td>--%>
    </tr>
    <%
        List<Property> allProperty = (List<Property>)session.getAttribute("allRace");
        for (Property property : allProperty) {
            System.out.println(property.getPid());
    %>
    <tr>
        <td><input type="checkbox" name="check" value="<%=property.getPid()%>"></td>
        <%--    <td><input type="checkbox"  value="<%=user.getId()%>"></td>--%>
        <td><%=property.getPid()%></td>
        <td><%=property.getAddress()%></td>
        <td><%=property.getPrice()%></td>
        <td><%=property.getArea()%></td>
        <td><%=property.getType()%></td>

        <td>
            <a href="updateRace.jsp?pid=<%=property.getPid()%>">修改</a>
            <a href="delRace?pid=<%=property.getPid()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
