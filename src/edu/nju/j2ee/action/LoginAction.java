package edu.nju.j2ee.action;

import edu.nju.j2ee.service.StudentManageService;
import edu.nju.j2ee.service.impl.StudentManageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;


/**
 * Created by ZhangYF on 2017/2/26.
 */
@Controller
public class LoginAction extends BaseAction{

    private static final long serialVersionUID = 1L;


    @Override
    public String execute() throws Exception {
        HttpSession httpSession = request.getSession(false);

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

}
