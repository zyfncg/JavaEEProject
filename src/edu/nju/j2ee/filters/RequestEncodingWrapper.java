package edu.nju.j2ee.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by Zhang YF on 2016/12/17.
 */
public class RequestEncodingWrapper extends HttpServletRequestWrapper {
    private String ENCODING;
    public RequestEncodingWrapper(HttpServletRequest request) {
        super(request);
        setContentType();
    }
    @Override
    public String getParameter(String name) {
        // TODO Auto-generated method stub
        String value = getRequest().getParameter(name);
        if (value != null) {
            try {
                byte[] b = value.getBytes("ISO-8859-1");
                value = new String(b, ENCODING);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }
    public void setContentType() {
        this.ENCODING = "utf-8";
        try {
            super.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
