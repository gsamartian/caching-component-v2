package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class ExampleWebFilter implements WebFilter {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, 
      WebFilterChain webFilterChain) {
    	LOG.info("Entering Fitler");
        serverWebExchange.getResponse()
          .getHeaders().add("web-filter", "web-filter-test");
        LOG.info("Leaving Filter");        
        return webFilterChain.filter(serverWebExchange);
    }
}