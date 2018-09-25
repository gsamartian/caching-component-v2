package com.demo.main;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="newend" , enableByDefault = true)
public class CustomHealthEndPoint {
	
	@ReadOperation
    public String health() {
       return "Welcome to Custom Health";
    }
	
	@ReadOperation
    public String customEndPointByName(@Selector String arg0) {
		return "Welcome to Custom Health: " + arg0;
    }
	
	@WriteOperation
    public void writeOperation(@Selector String arg0 ,String tester) {
        System.out.println("Received name:" +arg0 + tester);
    }
}
