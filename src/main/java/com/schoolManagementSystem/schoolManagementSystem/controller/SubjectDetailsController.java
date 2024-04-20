package com.schoolManagementSystem.schoolManagementSystem.controller;


import com.schoolManagementSystem.schoolManagementSystem.model.SubjectDetails;
import com.schoolManagementSystem.schoolManagementSystem.service.SubjectInfoService;
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
    public ResponseEntity<SubjectDetails> addSubjectDetails(@RequestBody SubjectDetails subjectDetails){
        SubjectDetails subjectDetails1 = subjectInfoService.addSubject(subjectDetails);
        log.info("Adding the data {}", subjectDetails);
        return new ResponseEntity<>(subjectDetails1, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<SubjectDetails> getSubjectDetails(String id){
        SubjectDetails subjectDetails = subjectInfoService.getSubjectDetails(id);
        return new ResponseEntity<>(subjectDetails, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<SubjectDetails>> getAllSubjectDetails(){
        List<SubjectDetails> subjectDetails = subjectInfoService.getAllSubjects();
        return new ResponseEntity<>(subjectDetails, HttpStatus.OK);
    }
}
