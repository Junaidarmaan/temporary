package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {
    
    @RequestMapping("/get")
    String get(){
        return "Working";
    }
    @RequestMapping("/greet")
    String greet(@RequestParam("name") String name){
        String response = "Hello " + name;
        return name;
    }


    
}

