package com.example.play_app_backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.play_app_backend.FormData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class FormController {
    @PostMapping
    public ResponseEntity<String> handleFormSubmission(@RequestBody FormData data){
        
        return ResponseEntity.ok("form data received successfully");
    }
}
