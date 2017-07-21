package com.dodo.filters;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RoutingFilter extends ZuulFilter   {
	
		private static Logger log = LoggerFactory.getLogger(SimpleFilterPre.class);
		private final String filterType ="pre";
		@Override
		public Object run() {
			RequestContext ctx = RequestContext.getCurrentContext();
			try{
				ctx.setRouteHost(new URL("http://localhost:8983"));
			}catch(MalformedURLException e){
				e.printStackTrace();
			}
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
			return 10;
		}
		@Override
		public String filterType() {
			// TODO Auto-generated method stub
			return filterType;
		}
}
