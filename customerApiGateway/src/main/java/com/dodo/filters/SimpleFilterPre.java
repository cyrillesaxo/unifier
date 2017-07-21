package com.dodo.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.dodo.archaius.CustomConfigurationListener;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
@RefreshScope
public class SimpleFilterPre extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilterPre.class);
	private final String filterType ="pre";
	private String blackList;
	
	public SimpleFilterPre(){
		CustomConfigurationListener myConfiguration= new CustomConfigurationListener(); 
		
		ConfigurationManager.getConfigInstance().addConfigurationListener(myConfiguration);
	}
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addOriginResponseHeader("cache-control", "max-age=3600"); //Setup a cache-control header
		ctx.addZuulRequestHeader("Test", "TestSample");
		
		HttpServletRequest request = ctx.getRequest();
		
/*		blackList = DynamicPropertyFactory.getInstance().getStringProperty("restrictedUrls", "NOT FOUND").get();
		CustomConfigurationListener myConfiguration= new CustomConfigurationListener(); 
		//DynamicPropertyFactory.initWithConfigurationSource(myConfiguration);
		ConfigurationManager.getConfigInstance().addConfigurationListener(myConfiguration);*/
		
		blackList = DynamicPropertyFactory.getInstance().getStringProperty("restrictedUrls", "NOT FOUND").get();
		// if we want to reject resources
		log.info("############################## ARCHAIUS ##########################");
		log.info(blackList);
		
		//blackList = ".*/ping";  //we will reject any access to "/location/Location/api/ping"
		//blackList = ".*/ping|.*/latitude/.*/longitude/.*";
		
        String uri = ctx.getRequest().getRequestURI();
        String appId = uri.split("/")[1];
        if (!"NOT FOUND".equals(blackList) && /*uri.contains(blackList)*/ uri.matches(blackList)) {
            ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
            ctx.getResponse().setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            //ctx.getResponse().setCharacterEncoding(CharsetConstants.CHARSET_UTF8);
        	ctx.setResponseBody("{ msg: 'access restricted' }");
            ctx.setSendZuulResponse(false);
            log.info("Request '{}' from {}:{} is blocked",
                    uri, ctx.getRequest().getRemoteHost(), ctx.getRequest().getRemotePort());
        }
		
		
		log.info("############################## PRE FILTER ##########################");
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURI()));
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
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return filterType;
	}

}
