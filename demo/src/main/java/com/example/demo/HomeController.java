package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Mapping for the endpoint "/createAccount"
    @GetMapping("/createAccount")
    public String createAccount(@RequestParam("id") String id) {
        // Create an instance of Storage class
        Storage storage = new Storage();

        // Call the newUser method of Storage class, passing id + ".txt"
        String Response = storage.newUser("storage/" + id + ".txt");

        // Return a response indicating the account creation
        return Response;
    }
}
