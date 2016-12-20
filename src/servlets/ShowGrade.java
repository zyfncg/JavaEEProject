package servlets;

import data.dataImpl.GradeDataImpl;
import data.dataService.GradeDataService;
import data.mysql.Database;
import listener.OnlineSessionListener;
import model.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYF on 2016/12/9.
 */
@WebServlet("/showgrade")
public class ShowGrade extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ShowGrade() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        processRequest(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        getGradeList(req, resp);
        displayGradelist(req, resp);
        displayLogoutPage(req, resp);
    }
    private void getGradeList(HttpServletRequest req, HttpServletResponse res){

        List list = new ArrayList();
        String studentID = (String)req.getAttribute("login");
        if(studentID == null){
            studentID = (String)req.getSession().getAttribute("login");
        }
        GradeDataService gradeData = new GradeDataImpl();
        list = gradeData.getGradeList(studentID);
        req.setAttribute("list", list);
    }
    private void displayGradelist(HttpServletRequest req, HttpServletResponse res){
        List list = (List) req.getAttribute("list"); // resp.sendRedirect(req.getContextPath()+"/MyStockList");
//        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<html><body>");
        out.println("<table width='650' border='0' >");
        out.println("<tr>");
        out.println("<td width='650' height='80' background='" + req.getContextPath() + "/image/top.jpg'>&nbsp;</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<p>Welcome " + req.getSession().getAttribute("login") + "</p>");

        out.println("My Grade List:  ");
        out.println("<table width='450' border='1'>");
        out.println("<tr><th>课程</th><th>笔试</th><th>实验</th><th>总成绩</th></tr>");


        for (int i = 0; i < list.size(); i++) {

            Grade grade = (Grade)list.get(i);
//            out.println(grade.getCourseName()+" "+grade.getGrade());
            out.println("<tr>");
            out.println("<td>"+grade.getCourseName()+"</td>");
            if(grade.isTest()){
                out.println("<td>"+grade.getExam()+"</td>");
                out.println("<td>"+grade.getLab()+"</td>");
                out.println("<td>"+grade.getGrade()+"</td>");
            }else{
                out.println("<td style='color:red'>未测验</td>");
                out.println("<td style='color:red'>未测验</td>");
                out.println("<td style='color:red'>未测验</td>");
                out.println("<script>alert('有未参加的测验')</script>");
            }

            out.println("</tr>");
        }
        out.println("</table>");
        // 点击here，刷新该页面，会话有效
        out.println("Click <a href='" + res.encodeURL(req.getRequestURI()) + "'>here</a> to reload this page.<br>");
    }

    public void displayLogoutPage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        // 注销Logout
        out.println("<form method='GET' action='" + res.encodeURL(req.getContextPath() + "/login") + "'>");
        out.println("</p>");
        out.println("<input type='submit' name='Logout' value='Logout'>");
        out.println("</form>");
        out.println("<p>当前登录人数： " + OnlineSessionListener.getLoginCounter()+"</p>");
        out.println("<p>当前在线人数： " + OnlineSessionListener.getOnlineCounter()+"</p>");
        out.println("</body></html>");

    }
}
