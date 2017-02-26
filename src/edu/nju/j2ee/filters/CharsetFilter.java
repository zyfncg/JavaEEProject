package edu.nju.j2ee.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class CharsetFilter
 */
public class CharsetFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			if("GET".equals(((HttpServletRequest) request).getMethod())){
				request = new RequestEncodingWrapper((HttpServletRequest)request);
			}else{
				request.setCharacterEncoding("utf-8");
			}
//			response = new BufferedResponse((HttpServletResponse)response);
			response.setContentType("text/html; charset=utf-8");
//			response.setCharacterEncoding("utf-8");
//			System.out.println("charset filter start");
			chain.doFilter(request, response);
			response.setCharacterEncoding("utf-8");

//			System.out.println("charset filter end");

		}//在servlet处理请求之前截获

	//	return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
