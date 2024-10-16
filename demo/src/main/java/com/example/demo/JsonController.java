package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {
    
    @RequestMapping("/get")
    String get(){
        return "Working";
    }


    
}

