package com.schoolManagementSystem.schoolManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class authenticationController {
    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> handleNotFound() {
        String errorMessage = "The requested resource was not found";
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
}
