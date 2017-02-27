<%@ page import="edu.nju.j2ee.listener.OnlineSessionListener" %><%--
  Created by IntelliJ IDEA.
  User: Zhang YF
  Date: 2016/12/29
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() + "/view/css/style.css"%>">
</head>
<body>

    <div class="login-body">
        <s:form method='POST' action='loginCheck'>
            <s:textfield class="input studentid form-control" name='studentid' placeholder="学号"/>
            <s:password class="input password form-control" name='password' placeholder="密码" />
            <s:submit class="submit-btn btn btn-lg btn-primary btn-block" name='Submit' value='Submit'/>

        </s:form>
        <br>
        <h3>当前在线人数： <%=OnlineSessionListener.getOnlineCounter()%></h3>
    </div>

</body>
</html>
