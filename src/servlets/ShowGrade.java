package servlets;

import data.Database;
import model.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                displayMyStocklistPage(req, resp);
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
            displayMyStocklistPage(req, resp);
            displayLogoutPage(req, resp);

        }
    }
    private void getGradeList(HttpServletRequest req, HttpServletResponse res){
        ResultSet ret = null;
        ArrayList list = new ArrayList();
        Database db = Database.getInstance();
        String studentID = (String)req.getAttribute("login");
        String sql = "select * from stud_cour where studentid='"+ studentID +"'";
        ret = db.query(sql);
        try {
            while (ret.next()){
                String courseName = ret.getString("coursename");
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

    }
}
