package com.dodo.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SimpleFilterPost extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(SimpleFilterPost.class);
	private final String filterType ="post";
	
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		
		log.info("############################## POST FILTER ##########################");
		log.info("REQUEST :: < "+request.getScheme()+" "+request.getLocalAddr()+" "+request.getLocalPort());
		log.info(" REQUEST :: < "+request.getMethod()+" "+request.getRequestURI()+" "+request.getProtocol());
		log.info(" RESPONSE :: > HTTP:"+response.getStatus());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return filterType;
	}

}
