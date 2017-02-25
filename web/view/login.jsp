<%@ page import="edu.nju.j2ee.listener.OnlineSessionListener" %><%--
  Created by IntelliJ IDEA.
  User: Zhang YF
  Date: 2016/12/29
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() + "/view/css/style.css"%>">
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    String login = "";
    if (null != cookies) {
        // Look through all the cookies and see if the cookie with the login info is there.
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("LoginCookie")) {
                login=cookie.getValue();
                break;
            }
        }
    }

%>
    <div class="login-body">
        <form method='POST' action='<%=response.encodeURL(request.getContextPath() + "/checklogin")%>'>
            <input type='text' class="studentid form-control" name='login' value="<%=login%>" placeholder="学号" required>
            <input type='password' class="password form-control" name='password' placeholder="密码" required>
            <input type='submit' class="submit-btn btn btn-lg btn-primary btn-block" name='Submit' value='Submit'>

        </form>
        <br>
        <h3>当前在线人数： <%=OnlineSessionListener.getOnlineCounter()%></h3>
    </div>

</body>
</html>
