package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    // Method to write data to a file
    public void write(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine(); // Add a new line after writing data
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public String read(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return content.toString();
    }


    // Creating New User (Creating a new file for that use)
    public String newUser(String path){
        File file = new File(path);
        String response = new String();

        try {
            // Create the file
            if (file.createNewFile()) {
                response =  "User created: " + file.getAbsolutePath();
            } else {
                response =  "User already exists please provide a different id";
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return response;
    }
}

