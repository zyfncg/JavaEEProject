<%@ page import="listener.OnlineSessionListener" %>
<%@ page import="model.Grade" %><%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2016/12/28
  Time: 20:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/taglib.tld" prefix="check" %>

<html>
<head>
    <title>Grade</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Theme style  -->
    <link rel="stylesheet" href="<%=request.getContextPath() + "/view/css/style.css"%>">
</head>
<body>
<check:checklogin/>
<div class="grade-page">
<p>welcome <%=request.getSession().getAttribute("login") %></p>
<jsp:useBean id="gradelist" type="model.GradeListBean" scope="session"/>

<%
    for (int i = 0; i < gradelist.getGradeList().size(); i++) {
    Grade grade = gradelist.getGrade(i);
    if(!grade.isTest()){
        out.println("<script>alert('有未参加的测验')</script>");
    }
    if(0 == i%3){
        out.println("<div class='row' style='height:240px;padding-left:36px;'>");
    }
%>
<div class="course-item col-md-4">
    <h3><%=grade.getCourseName()%></h3>
    <div class="grade">
        <div class="score-element" style="color:<%=grade.getExam()>1?"black":"red"%>">
            <p>笔试: <%=grade.getExam()%></p>
        </div>
        <div class="score-element" style="color:<%=grade.getLab()>1?"black":"red"%>">
            <p>实验: <%=grade.getLab()%></p>
        </div>
        <div class="score-element" style="color:<%=grade.getGrade()>1?"black":"red"%>">
            <p>总成绩: <%=grade.getGrade()%></p>
        </div>
    </div>
</div>
<%
        if(2 == i%3){
            out.println("</div>");
        }
    }
%>
<p>Click <a href="<%=response.encodeURL(request.getRequestURL().toString())%>">here</a> to reload this page.</p>
<br>
<form method='GET' action="<%=response.encodeURL(request.getContextPath()+"/login")%>">
    <input type='submit' name='Logout' value='Logout'>
</form>
<p>当前登录人数：<%=OnlineSessionListener.getLoginCounter()%></p>
<p>当前登录人数：<%=OnlineSessionListener.getOnlineCounter()%></p>
</div>
</body>
</html>
