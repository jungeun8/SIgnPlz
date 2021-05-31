package signPlz.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import io.swagger.annotations.ApiOperation;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
	private static final String HEADER_AUTH = "Authorization";
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod)handler;
			return true; 
		
	}
}
