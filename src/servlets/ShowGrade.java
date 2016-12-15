package servlets;

import data.mysql.Database;
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
        HttpSession session = req.getSession(false);
        boolean cookieFound = false;
        System.out.println(req.getParameter("login") + " req");
        Cookie cookie = null;
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            // Look through all the cookies and see if the
            // cookie with the login info is there.
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("LoginCookie")) {
                    cookieFound = true;
                    break;
                }
            }
        }

        if (session == null) {
            String loginValue = req.getParameter("login");
            boolean isLoginAction = (null == loginValue) ? false : true;

            System.out.println(loginValue + " session null");
            if (isLoginAction) { // User is logging in
                if (cookieFound) { // If the cookie exists update the value only
                    // if changed
                    if (!loginValue.equals(cookie.getValue())) {
                        cookie.setValue(loginValue);
                        resp.addCookie(cookie);
                    }
                } else {
                    // If the cookie does not exist, create it and set value
                    cookie = new Cookie("LoginCookie", loginValue);
                    cookie.setMaxAge(Integer.MAX_VALUE);
                    System.out.println("Add cookie");
                    resp.addCookie(cookie);
                }

                // create a session to show that we are logged in
                session = req.getSession(true);
                session.setAttribute("login", loginValue);

                req.setAttribute("login", loginValue);
                getGradeList(req, resp);
                displayGradelist(req, resp);
                displayLogoutPage(req, resp);

            } else {
                System.out.println(loginValue + " session null");
                // Display the login page. If the cookie exists, set login
                resp.sendRedirect(req.getContextPath() + "/Login");
            }
        } else {
            // 或未注销，重新加载该页面，session不为空
            String loginValue = (String) session.getAttribute("login");
            System.out.println(loginValue + " session");

            req.setAttribute("login", loginValue);
            getGradeList(req, resp);
            displayGradelist(req, resp);
            displayLogoutPage(req, resp);

        }
    }
    private void getGradeList(HttpServletRequest req, HttpServletResponse res){
        ResultSet ret = null;
        List list = new ArrayList();
        Database db = Database.getInstance();
        String studentID = (String)req.getAttribute("login");
        String sql = "select * from gradeView where studentid='"+ studentID +"';";
        ret = db.query(sql);
        try {
            while (ret.next()){
                String courseName = ret.getString("coursename");
                System.out.println(courseName);
                double score = ret.getDouble("grade");
                Grade grade = new Grade(studentID,courseName,score);
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("list", list);
    }
    private void displayGradelist(HttpServletRequest req, HttpServletResponse res){
        List list = (List) req.getAttribute("list"); // resp.sendRedirect(req.getContextPath()+"/MyStockList");
        res.setContentType("text/html; charset=utf-8");
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
        out.println("<p>Welcome " + req.getAttribute("login") + "</p>");

        out.println("My Grade List:  ");
        System.out.println("gradelist");
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade) list.get(i);
            out.println(grade.getCourseName()+" "+grade.getGrade());
        }
        out.println("</p>");
        // 点击here，刷新该页面，会话有效
        out.println("Click <a href='" + res.encodeURL(req.getRequestURI()) + "'>here</a> to reload this page.<br>");
    }

    public void displayLogoutPage(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        // 注销Logout
        out.println("<form method='GET' action='" + res.encodeURL(req.getContextPath() + "/Login") + "'>");
        out.println("</p>");
        out.println("<input type='submit' name='Logout' value='Logout'>");
        out.println("</form>");
        out.println("<p>Servlet is version @version@</p>");
        out.println("</body></html>");

    }
}
