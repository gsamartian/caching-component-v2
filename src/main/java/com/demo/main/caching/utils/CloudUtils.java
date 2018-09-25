package com.demo.main.caching.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class CloudUtils {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.application.name}")
	private String appName;

	
	@Value("${eureka.client.enabled:true}")
	private boolean eurekaClient;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	private DiscoveryClient  discoveryClient;

	private List<ServiceInstance> getServiceInstances() {
		LOG.info("Entering...");
		LOG.info("AppName is: {}",appName);
	    List<ServiceInstance> list = discoveryClient.getInstances(appName);
	    LOG.info("serviceInstances is: {}",list);
	    LOG.info("Leaving..");
	    return list;
	}

	public List<URI> getURIList(){
		LOG.info("Entering...");
		
		List<URI> uriList=new ArrayList<>();
		try {
			if(!eurekaClient) {
				LOG.info("Instance is StandAlone");
				uriList.add(new URI("http://localhost:"+serverPort));
			}else {
				LOG.info("Instance is EurekaClient");
				List<ServiceInstance> serviceInstances=getServiceInstances();
				if(null!=serviceInstances && serviceInstances.size()>0) {
					serviceInstances.forEach( (instance) -> {
							uriList.add(instance.getUri());
					});
				}else {
					LOG.info("No Instances Available");;
				}
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		LOG.info("Leaving..");
		return uriList;
	}
	
	public String getTokenForEnvironment() {
		return "token";
	}
}
