package com.example.demo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class JsonController {
    Gson gson = new Gson();
    Storage storage = new Storage();


    @RequestMapping("/newTask")
    String save(@RequestBody String taskinfo,@RequestParam("id") int id){
        String path = String.format("storage/%d.txt",id);
        storage.write(path, taskinfo);
        return "Task Added successfully";
    }


    @RequestMapping("/get")
    String get(@RequestParam("id") int id){
        String path = "storage/" + id + ".txt";
        String response = storage.read(path);
        return response;
    }


    @RequestMapping("newUser")
    String newUser(@RequestParam("id") String id){
        String response = " ";
        response = storage.newUser("storage/"+id + ".txt");
        return response;
    }
}

class Task{
    int id;
    String task;
}