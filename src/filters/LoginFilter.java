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


        if (session == null) {
            System.out.println("session null");
            // Display the login page. If the cookie exists, set login
            response.sendRedirect(request.getContextPath() + "/login");

        } else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }

}
