package com.RaiseTech.Work06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public Map<String ,String> hello(){
        return Map.of("message","hello world");
    }
}
