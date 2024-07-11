<%@ page import="cn.edu.lingnan.pojo.Property" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.Property" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/1.css">


</head>
<body>
<h1 align="center">修改竞赛信息页面</h1>
<hr><br><a href="/loginout">注销</a><br><hr>
<form action="updateRace">
    <table>
        <tr>

            <td>竞赛编号</td>
            <td>竞赛名称</td>
            <td>备注信息</td>
            <td>选择操作</td>
        </tr>
        <%
            List<Property> allProperty = (List<Property>)session.getAttribute("allProperty");

            String pid = request.getParameter("pid");
            System.out.println(pid);
            for (Property property : allProperty) {

                if (property.getRid().equals(pid)){
                    System.out.println(property.getRid());
        %>
        <tr>
            <td><input type="hidden" name="pid" value="<%=property.getRid()%>"><%=property.getRid()%></td>
            <td><input type="text" name="rname" value="<%=property.getRname()%>"></td>
            <td><input type="text" name="rflag" value="<%=property.getRflag()%>"></td>

            <td>
                <input type="submit" value="确认修改"/>
            </td>
        </tr>
        <%
                }}
        %>

    </table>
</form>
</body>
</html>
