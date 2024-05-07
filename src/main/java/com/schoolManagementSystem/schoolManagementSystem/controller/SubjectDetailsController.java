package com.schoolManagementSystem.schoolManagementSystem.controller;


import com.schoolManagementSystem.schoolManagementSystem.model.SubjectDetails;
import com.schoolManagementSystem.schoolManagementSystem.service.SubjectInfoService;
import com.schoolManagementSystem.schoolManagementSystem.utilities.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectDetailsController {
    private static final Logger log = LoggerFactory.getLogger(SubjectDetailsController.class);
    @Autowired
    private SubjectInfoService subjectInfoService;


    @PostMapping
    public RestResponse addSubjectDetails(@RequestBody SubjectDetails subjectDetails){
        try {

            SubjectDetails subjectDetails1 = subjectInfoService.addSubject(subjectDetails);
            log.info("Adding the data {}", subjectDetails);
            return RestResponse.builder().status(HttpStatus.OK.value()).message("Subject added successfully").data(subjectDetails).build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("something went wrong").build();
        }
    }
    @GetMapping
    public RestResponse getSubjectDetails(String id){
        try {
            SubjectDetails subjectDetails = subjectInfoService.getSubjectDetails(id);
            return RestResponse.builder().status(HttpStatus.OK.value()).message("Successfully fetched details").data(subjectDetails).build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Something went wrong").build();
        }
    }
    @GetMapping("/all")
    public RestResponse getAllSubjectDetails(){
        try {
            List<SubjectDetails> subjectDetails = subjectInfoService.getAllSubjects();
            return RestResponse.builder().status(HttpStatus.OK.value()).message("Fetched all details").data(subjectDetails).build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Something went wrong").build();
        }
    }
}
