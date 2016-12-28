<%@ page import="listener.OnlineSessionListener" %>
<%@ page import="model.Grade" %><%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2016/12/28
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>welcome <%=request.getSession().getAttribute("login") %></p>
<jsp:useBean id="gradelist" type="model.GradeListBean" scope="session"></jsp:useBean>

<%
    for (int i = 0; i < gradelist.getGradeList().size(); i++) {
    Grade grade = gradelist.getGrade(i);
%>
<div class="course-item">
    <h3><%=grade.getCourseName()%></h3>
    <div class="grade">
        <div class="score-element">
            <p>笔试</p>
            <p><%=grade.getExam()%></p>
        </div>
        <div class="score-element">
            <p>实验</p>
            <p><%=grade.getLab()%></p>
        </div>
        <div class="score-element">
            <p>总成绩</p>
            <p><%=grade.getGrade()%></p>
        </div>
    </div>
</div>
<%}%>
<p>Click <a href="<%=response.encodeURL(request.getRequestURL().toString())%>">here</a> to reload this page.</p>
<br>
<form method='GET' action="<%=response.encodeURL(request.getContextPath()+"/login")%>">
    <input type='submit' name='Logout' value='Logout'>
</form>
<p>当前登录人数：<%=OnlineSessionListener.getLoginCounter()%></p>
<p>当前登录人数：<%=OnlineSessionListener.getOnlineCounter()%></p>

</body>
</html>
