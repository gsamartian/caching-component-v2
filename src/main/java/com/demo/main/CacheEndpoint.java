package com.demo.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "mycaches", enableByDefault = true)
@Component
public class CacheEndpoint {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@ReadOperation
	public String caches() {
		LOG.info("Entering caches");
		return "Welcome to cacheEndpoint";
	}

	@WriteOperation
	public String invalidateCacheKeys(@Selector String arg0, List<String> cacheKeyList) {
		LOG.info("Entering invalidateCacheKeys..");
		LOG.info("Received params: cacheName: {}, cacheKeyList:{}", arg0, cacheKeyList);
		return "Successfully Deleted Cache Keys";
	}

	@ReadOperation
	public String getCache(@Selector String arg0) {
		LOG.info("Entering getCache..");
		LOG.info("Received params: cacheName: {}", arg0);
		return "Successfully Fetched Cache ";
	}

}
