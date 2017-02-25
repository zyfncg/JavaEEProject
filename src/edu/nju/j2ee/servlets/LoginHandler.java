package edu.nju.j2ee.servlets;

import edu.nju.j2ee.factory.ServiceFactory;
import edu.nju.j2ee.service.StudentManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Zhang YF on 2016/12/29.
 */
@WebServlet("/checklogin")
public class LoginHandler extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        boolean cookieFound = false;
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
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
            System.out.println("session null");
            // Display the login page. If the cookie exists, set login
            response.sendRedirect(request.getContextPath() + "/login");

        } else {
            if(null == session.getAttribute("login")){
                String loginValue = request.getParameter("login");
                String userid = loginValue;
                String password = request.getParameter("password");
//                boolean isLoginAction = (null == loginValue) ? false : true;
                boolean isLoginAction = isVaildUser(userid, password);

                if (isLoginAction) { // User is logging in
                    if (cookieFound) { // If the cookie exists update the value only
                        // if changed
                        if (!loginValue.equals(cookie.getValue())) {
                            cookie.setValue(loginValue);
                            response.addCookie(cookie);
                        }
                    } else {
                        // If the cookie does not exist, create it and set value
                        cookie = new Cookie("LoginCookie", loginValue);
                        cookie.setMaxAge(Integer.MAX_VALUE);
                        System.out.println("Add cookie");
                        response.addCookie(cookie);
                    }

                    // create a session to show that we are logged in
//                session = request.getSession(true);

                    session.setAttribute("login", loginValue);
                    request.setAttribute("login", loginValue);

                    response.sendRedirect(request.getContextPath() + "/showmygrade");

                }else{
                    response.sendRedirect(request.getContextPath() + "/IDError.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/showmygrade");
            }
        }
    }

    private boolean isVaildUser(String userid, String psssword){
        StudentManageService studentManageService = ServiceFactory.getStudentManageService();
        return studentManageService.checkPassword(userid, psssword);
    }

}
