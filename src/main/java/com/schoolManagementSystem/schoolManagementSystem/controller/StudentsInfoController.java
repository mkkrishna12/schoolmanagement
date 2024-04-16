package com.schoolManagementSystem.schoolManagementSystem.controller;

import com.schoolManagementSystem.schoolManagementSystem.model.*;
import com.schoolManagementSystem.schoolManagementSystem.service.StudentInfoService;
import org.apache.juli.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.apache.juli.logging.Log.*;

@RestController
@RequestMapping("/studentsInfo")
public class StudentsInfoController {

    private static final Logger log = LogManager.getLogger(StudentsInfoController.class);
    @Autowired(required = true)
    StudentInfoService studentInfoService;
    @GetMapping
    public ResponseEntity<List<StudentInfo>> getStudents(){
        log.info("Fetching All Student List ");
        List<StudentInfo> studentInfoList = studentInfoService.getAllStudent();
        return new ResponseEntity<>(studentInfoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody StudentInfo studentInfo){
        log.info("adding student {}", studentInfo);
        studentInfoService.addUser(studentInfo);
        return new ResponseEntity("User inserted", HttpStatus.OK);
    }
}
