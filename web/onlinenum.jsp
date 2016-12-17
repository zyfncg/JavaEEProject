<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>online number</title>
</head>
<body>
<p>
    当前登录人数：
    <%
        int loginNum = 23;
        out.println(loginNum);
    %>
</p>
<p>
    当前在线人数：
    <%
        int onlineNum = 88;
        out.println(onlineNum);
    %>
</p>

</body>
</html>