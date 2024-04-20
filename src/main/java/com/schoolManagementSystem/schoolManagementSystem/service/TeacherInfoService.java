package com.schoolManagementSystem.schoolManagementSystem.service;

import com.schoolManagementSystem.schoolManagementSystem.model.TeacherInfo;
import com.schoolManagementSystem.schoolManagementSystem.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherInfoService {
    private static final Logger log = LoggerFactory.getLogger(StudentInfoService.class);
    @Autowired
    private TeacherRepository teacherRepository;


    public List<TeacherInfo> getAllTeachers() {

            List<TeacherInfo> teacherInfos =   teacherRepository.findAll();
            return teacherInfos;

    }
    public TeacherInfo getTeacherInfoById(String id){
        return teacherRepository.findTeacherById(id);
    }
    public TeacherInfo addUser(TeacherInfo teacherInfo) {
        TeacherInfo teacherInfo1 = teacherRepository.save(teacherInfo);
        return teacherInfo1;
    }
}
