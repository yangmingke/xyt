package com.xyt.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutFilter implements Filter  {

	private static List<String> whiteList;

    static {//不过滤列表
        whiteList = new ArrayList<String>();
        whiteList.add("/");
		whiteList.add("/userController/login");
		whiteList.add("/userController/logout");
        whiteList.add("/login.jsp");
		whiteList.add("/jsp/login.jsp");
        whiteList.add("/logout.jsp");
		whiteList.add("/jsp/logout.jsp");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {


		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse  response = (HttpServletResponse ) resp;
        String requstURI = request.getRequestURI();
        
        // 白名单不验证登陆
        if (whiteList.contains(requstURI)) {
            chain.doFilter(req, resp);
            return;
        }

        HttpSession session = request.getSession();
		Object u = session.getAttribute("adminSession");
		if(u==null){
			response.sendRedirect("/jsp/logout.jsp");
			return;
		}else{
			session.setAttribute("adminSession", u);
			chain.doFilter(req, resp);
			return;
		}
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	}

}
