package filters;

import dao.daoImpl.StudentDaoImpl;
import dao.daoService.StudentDao;
import factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zhang YF on 2016/12/18.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
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


                    filterChain.doFilter(request,response);
                }else{
                    response.sendRedirect(request.getContextPath() + "/IDError.jsp");
                }
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isVaildUser(String userid, String psssword){
        StudentDao checkUser = DaoFactory.getStudentDao();
        return checkUser.checkPassword(userid, psssword);
    }
}
