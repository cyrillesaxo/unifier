package com.dodo.filters;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class requestDelayFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilterPre.class);
	private final String filterType ="pre";
	private static Random rand = new Random();
	
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(rand.nextInt(20000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return RequestContext.getCurrentContext().getRequest().getParameter("clientName").equals("canary")?true:false;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return filterType;
	}

}
