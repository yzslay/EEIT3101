package com.petpet.util;

import java.io.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;

@WebFilter(urlPatterns="/*",
		   initParams= @WebInitParam(name="encoding",value="UTF-8"))
public class EncodingFilter implements Filter {
	String encoding = null;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
