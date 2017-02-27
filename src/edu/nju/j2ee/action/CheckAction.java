package edu.nju.j2ee.action;

import javax.servlet.http.HttpSession;

/**
 * Created by ZhangYF on 2017/2/26.
 */
public class CheckAction extends BaseAction{
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
