package com.schoolManagementSystem.schoolManagementSystem.controller;

import com.schoolManagementSystem.schoolManagementSystem.model.*;
import com.schoolManagementSystem.schoolManagementSystem.service.StudentInfoService;
import com.schoolManagementSystem.schoolManagementSystem.utilities.RestResponse;
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

    @GetMapping("/all")
    public RestResponse getStudents(){
        try{
            List<StudentInfo> studentInfoList = studentInfoService.getAllStudent();

            log.info("Fetching All Student List {}", studentInfoList);
            return RestResponse.<List<StudentInfo>>builder().data(studentInfoList).status(HttpStatus.OK.value()).message("Successfull").build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Something went wrong").build();

        }
    }


    @GetMapping("/{id}")
    public RestResponse getStudentById(@PathVariable String id){
        try {
            log.info("Searching for the resource {}", id);
            StudentInfo studentInfo = studentInfoService.getStudentById(id);
            return RestResponse.builder().status(HttpStatus.OK.value()).data(studentInfo).message("Successfully retrived data").build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Something went wrong").build();
        }
    }
    @PostMapping()
    public RestResponse addUser(@RequestBody StudentInfo studentInfo){
        try{
            log.info("adding student {}", studentInfo);
            StudentInfo studentInfo1 = studentInfoService.addUser(studentInfo);
            return RestResponse.builder().status(HttpStatus.OK.value()).data(studentInfo).message("Successfully added data").build();
        }catch (Exception e){
            return RestResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Something went wrong").build();

        }
    }
}
