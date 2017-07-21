package com.dodo.filters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.util.HTTPRequestUtils;

public class RedirectFilter extends ZuulFilter   {
	private static Logger log = LoggerFactory.getLogger(SimpleFilterPre.class);
	private final String filterType ="pre";
	
	@Override
	public Object run() {
		
		try {
			RequestContext.getCurrentContext().setRouteHost(new URL("http://example.com"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(HTTPRequestUtils.getInstance().getQueryParams() == null){
			RequestContext.getCurrentContext().setRequestQueryParams(new HashMap<String, List<String>>());
		}
		
		List par = new ArrayList<String>();
		par.add("true");
		
		HTTPRequestUtils.getInstance().getQueryParams().put("debugRequest", par);
		RequestContext.getCurrentContext().setDebugRequest(true);
		RequestContext.getCurrentContext().setSendZuulResponse(true);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return RequestContext.getCurrentContext().getRequest().getRequestURI().matches("/api/redirect.*");
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return filterType;
	}

}
