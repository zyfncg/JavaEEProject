package edu.nju.j2ee.action;

import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


/**
 * Created by ZhangYF on 2017/2/26.
 */
@Controller
public class LoginAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private String login;

    @Override
    public String execute() throws Exception {
        HttpSession httpSession = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (null != cookies) {
            // Look through all the cookies and see if the cookie with the login info is there.
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("LoginCookie")) {
                    login=cookie.getValue();
                    break;
                }
            }
        }
        if (httpSession == null){
            httpSession = request.getSession(true);
        }

        // Logout action removes session, but the cookie remains
        if (null != request.getParameter("Logout")) {
            if (null != httpSession.getAttribute("login")) {
                httpSession.removeAttribute("login");
            }
        }
        return "success";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
