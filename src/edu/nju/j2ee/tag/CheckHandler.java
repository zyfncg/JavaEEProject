package edu.nju.j2ee.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;


/**
 * Created by Zhang YF on 2016/12/29.
 */
public class CheckHandler extends BodyTagSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {


        return SKIP_BODY;
    }


    @Override
    public void doInitBody() throws JspException {
        super.doInitBody();
    }

    @Override
    public void setBodyContent(BodyContent b) {
        super.setBodyContent(b);
    }

    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }


    @Override
    public int doEndTag() throws JspException {
        System.out.println("tld process");
        HttpSession session = pageContext.getSession();
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        if(null == session){
            System.out.println("session is null!!!!");
            try {
                response.sendRedirect(request.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return SKIP_PAGE;
        }else{
            String login = (String)session.getAttribute("login");
            if(null == login){
                System.out.println("login is null!!!!");
                System.out.println(request.getContextPath() + "/login");
                try {
                    response.sendRedirect(request.getContextPath() + "/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return SKIP_PAGE;
            }
        }
        System.out.println("check passed");
        return EVAL_PAGE;
    }
}
