package com.dodo.zuul.pattern;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

public class ZuulServiceRouteMapper {
	
	
	//serviceId "myusers-v1"  => "/v1/myusers/**"
	//autopayment-v1  =>  /v1/autopayment/**
	//autopayment-v2  => /v2/autopayment/**
	//autopayment-1.0.0 => /1.0.0/autopayment/**
	
	//@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
	}
	
}
