package com.dodo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class SimpleFilterError extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilterPre.class);
	private final String filterType ="error";
	
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
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
