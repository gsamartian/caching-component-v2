package com.demo.main.caching.config.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "caches")
@Component
public class CachesEndpoint {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@ReadOperation
	public Map<String, Object> caches() {
		LOG.info("Fetching Caches...");
		return new HashMap<>();
	}

	@ReadOperation
	public String getCachebyName(@Selector String name) {
		LOG.info("Fetching Caches by name: {}",name);
		return "Welcome:" + name;
	}

	@WriteOperation
	public String setCacheByName(@Selector String name, String  expirySeconds) { 
		return "Received name:" + name + " and level " + expirySeconds;
	}

}