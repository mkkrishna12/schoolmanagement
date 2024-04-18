package com.schoolManagementSystem.schoolManagementSystem.controller;


import com.schoolManagementSystem.schoolManagementSystem.model.TeacherInfo;
import com.schoolManagementSystem.schoolManagementSystem.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teacher")
public class TeacherInfoController {
    @Autowired
    private TeacherInfoService teacherInfoService;
    @GetMapping
    public ResponseEntity<TeacherInfo> getTeacherInfo(String id){
        TeacherInfo teacherInfo = teacherInfoService.getTeacherInfoById(id);
        return new ResponseEntity<>(teacherInfo, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<TeacherInfo>> getAllTeachers(){
        List<TeacherInfo> teacherInfos = teacherInfoService.getAllTeachers();
        return new ResponseEntity<>(teacherInfos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TeacherInfo> addTeacher(@RequestBody TeacherInfo teacherInfo){
        return new ResponseEntity<>(teacherInfoService.addUser(teacherInfo), HttpStatus.OK);
    }

}

