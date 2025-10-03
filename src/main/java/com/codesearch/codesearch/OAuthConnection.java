package com.codesearch.codesearch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthConnection {
    
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
