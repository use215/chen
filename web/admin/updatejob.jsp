<%@ page import="cn.edu.lingnan.pojo.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.pojo.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/1.css">
</head>
<body>
<h1 align="center">修改评分信息页面</h1>
<hr><br><a href="/loginout">注销</a><br><hr>





<form action="updateSpo">
    <table>
        <tr>

            <td>学生编号</td>
            <td>竞赛编号</td>
            <td>竞赛奖励</td>
            <td>备注信息</td>
            <td>选择操作</td>
        </tr>
        <%
            List<Job> allSpo = (List<Job>)session.getAttribute("allSpo");
            String id = request.getParameter("id");
            for (Job job : allSpo) {
                if (job.getId().equals(id)){
        %>
        <tr>
            <td><input type="hidden" name="id" value="<%=job.getId()%>"><%=job.getId()%></td>
            <td><input type="text" name="cid" value="<%=job.getRid()%>"></td>
            <td><input type="text" name="score" value="<%=job.getJob()%>"></td>
            <td><input type="text" name="pflag" value="<%=job.getJflag()%>"></td>

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
