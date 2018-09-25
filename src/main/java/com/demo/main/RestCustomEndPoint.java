package com.demo.main;

import java.util.List;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RestControllerEndpoint(id = "restendpoint")
public class RestCustomEndPoint {

    @GetMapping("/custom")
    public @ResponseBody ResponseEntity<String> customEndPoint(){
        return  new ResponseEntity<>("REST end point", HttpStatus.OK);
    }
    
    @PostMapping("/addme")
    public @ResponseBody ResponseEntity<String> addMe(@RequestBody List<String> namelist){
    	System.out.println("post mapping: namelist: " + namelist);
        return  new ResponseEntity<>("REST end point", HttpStatus.OK);
    }
}