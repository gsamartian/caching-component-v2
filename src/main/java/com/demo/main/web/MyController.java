package com.demo.main.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/new")
public class MyController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@GetMapping(path = "/{name}")
	public Mono<String> getName(@PathVariable String name) {
		LOG.info("Inside MyContorller getName");
	    return Mono.just(name);
	}
}
