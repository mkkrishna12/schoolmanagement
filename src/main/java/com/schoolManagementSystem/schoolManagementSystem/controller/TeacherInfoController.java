package com.schoolManagementSystem.schoolManagementSystem.controller;


import com.schoolManagementSystem.schoolManagementSystem.model.TeacherInfo;
import com.schoolManagementSystem.schoolManagementSystem.service.TeacherInfoService;
import com.schoolManagementSystem.schoolManagementSystem.utilities.RestResponse;
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
    public RestResponse getTeacherInfo(String id){

        try {
            TeacherInfo teacherInfo = teacherInfoService.getTeacherInfoById(id);
            return RestResponse.builder().data(teacherInfo).message("Fetched all details").status(HttpStatus.OK.value()).build();
        }catch (Exception e){
            return RestResponse.builder().message("Something went wrong").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        }
    }
    @GetMapping("/all")
    public RestResponse getAllTeachers(){
        try {

            List<TeacherInfo> teacherInfos = teacherInfoService.getAllTeachers();
            return RestResponse.builder().data(teacherInfos).message("Fetched all details").status(HttpStatus.OK.value()).build();
        }catch (Exception e){
            return RestResponse.builder().message("Something went wrong").status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
        }
    }
    @PostMapping
    public RestResponse addTeacher(@RequestBody TeacherInfo teacherInfo){
        try {
            return RestResponse.builder().data(teacherInfoService.addUser(teacherInfo)).message("Successfully added teacher").status( HttpStatus.OK.value()).build();
        }catch (Exception e){
            return RestResponse.builder().message("Something went wrong ").status( HttpStatus.OK.value()).build();
        }
    }
    @PostMapping("/attendence")
    public  RestResponse addAttendence(@RequestBody String []studentIds){
        try {
            return RestResponse.builder().data(teacherInfoService.addAttendence(studentIds)).message("Updated attendece for date").build();
        }catch (Exception e){
            return RestResponse.builder().message("Something went wrong ").status( HttpStatus.OK.value()).build();
        }
    }
}

