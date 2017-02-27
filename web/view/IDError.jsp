<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>online number</title>
</head>
<body>
<h1 style="color: crimson">
    学号或密码错误！
</h1>
<h1>
    <%
        String path = request.getContextPath();
        out.println("<a href="+path+"/login>点击这里重新登录</a>");
    %>

</h1>

</body>
</html>