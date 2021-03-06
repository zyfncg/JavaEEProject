<%@ page import="edu.nju.j2ee.listener.OnlineSessionListener" %>
<%@ page import="edu.nju.j2ee.model.Grade" %>
<%@ page import="edu.nju.j2ee.model.GradeListBean" %><%--
  Created by IntelliJ IDEA.
  User: ZhangYF
  Date: 2016/12/28
  Time: 20:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/taglib.tld" prefix="check" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
<%
    GradeListBean gradelist = (GradeListBean)request.getSession().getAttribute("gradelist");
    for (int i = 0; i < gradelist.getGradeList().size(); i++) {
    Grade grade = gradelist.getGrade(i);
    if(grade.getExam() == null||grade.getLab() == null||grade.getGrade() == null){
        out.println("<script>alert('有未参加的测验')</script>");
    }
    if(0 == i%3){
        out.println("<div class='row' style='height:240px;padding-left:36px;'>");
    }
%>
<div class="course-item col-md-4">
    <h3><%=grade.getCourse().getCoursename()%></h3>
    <div class="grade">
        <div class="score-element" style="color:<%=grade.getExam()!=null?"black":"red"%>">
            <p>笔试: <% if(grade.getExam()!=null) out.println(grade.getExam());%></p>
        </div>
        <div class="score-element" style="color:<%=grade.getLab()!=null?"black":"red"%>">
            <p>实验: <% if(grade.getLab()!=null) out.println(grade.getLab());%></p>
        </div>
        <div class="score-element" style="color:<%=grade.getGrade()!=null?"black":"red"%>">
            <p>总成绩: <% if(grade.getGrade()!=null) out.println(grade.getGrade());%></p>
        </div>
    </div>
</div>
<%
        if(2 == i%3 || i== gradelist.getGradeList().size()-1){
            out.println("</div>");
        }

    }
%>

</div>
<p>Click <a href="<%=response.encodeURL(request.getRequestURL().toString())%>">here</a> to reload this page.</p>
<br>
<form method='GET' action="<%=response.encodeURL(request.getContextPath()+"/login")%>">
    <input type='submit' name='Logout' value='Logout'>
</form>
<p>当前登录人数：<%=OnlineSessionListener.getLoginCounter()%></p>
<p>当前登录人数：<%=OnlineSessionListener.getOnlineCounter()%></p>
</body>
</html>
