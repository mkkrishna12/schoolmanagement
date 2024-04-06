package com.schoolManagementSystem.schoolManagementSystem.controller;

import com.schoolManagementSystem.schoolManagementSystem.model.*;
import com.schoolManagementSystem.schoolManagementSystem.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/studentsInfo")
public class StudentsInfoController {

    @Autowired(required = true)
    StudentInfoService studentInfoService;
    @GetMapping
    public ResponseEntity<List<StudentInfo>> getStudents(){
        List<StudentInfo> studentInfoList = this.studentInfoService.getAllStudent();
        return new ResponseEntity<>(studentInfoList, HttpStatus.OK);
    }
}
