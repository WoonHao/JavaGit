package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest hRequest = (HttpServletRequest) req;
		String type = hRequest.getMethod();
		EncodingHttpServletRequest myRequest = null;
		if(type.equals("GET")){
			myRequest = new EncodingHttpServletRequest(hRequest);
			chain.doFilter(myRequest, response);
		}
		if(type.equals("POST")){
			req.setCharacterEncoding("utf-8");
			chain.doFilter(hRequest, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
