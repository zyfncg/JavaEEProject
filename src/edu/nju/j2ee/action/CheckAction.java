package edu.nju.j2ee.action;

import edu.nju.j2ee.service.StudentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhangYF on 2017/2/26.
 */
@Controller
public class CheckAction extends BaseAction{
    private static final long serialVersionUID = 1L;

    private String studentid;
    private String password;

    @Autowired
    private StudentManageService studentManageService;

    @Override
    public String execute() throws Exception {
        HttpSession httpSession = request.getSession(false);

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

        if (httpSession == null) {
            System.out.println("session null");
            // Display the login page. If the cookie exists, set login
            return "login";

        } else {
            if(null == httpSession.getAttribute("login")){

                boolean isLoginAction = isVaildUser(studentid, password);

                if (isLoginAction) { // User is logging in
                    if (cookieFound) { // If the cookie exists update the value only
                        // if changed
                        if (!studentid.equals(cookie.getValue())) {
                            cookie.setValue(studentid);
                            response.addCookie(cookie);
                        }
                    } else {
                        // If the cookie does not exist, create it and set value
                        cookie = new Cookie("LoginCookie", studentid);
                        cookie.setMaxAge(Integer.MAX_VALUE);
                        System.out.println("Add cookie");
                        response.addCookie(cookie);
                    }

                    // create a session to show that we are logged in
//                session = request.getSession(true);

                    httpSession.setAttribute("login", studentid);
                    request.setAttribute("login", studentid);

                    return "success";

                }else{
                    return "fail";
                }
            }else{
                return "success";
            }

        }

    }

    private boolean isVaildUser(String userid, String psssword){
        return studentManageService.checkPassword(userid, psssword);
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
