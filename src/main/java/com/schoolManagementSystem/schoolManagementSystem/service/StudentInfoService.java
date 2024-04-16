package com.schoolManagementSystem.schoolManagementSystem.service;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.schoolManagementSystem.schoolManagementSystem.model.*;
import com.schoolManagementSystem.schoolManagementSystem.repository.StudentRepository;
import org.apache.el.parser.BooleanNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentInfoService {
    private static final Logger log = LoggerFactory.getLogger(StudentInfoService.class);
    @Autowired
    private StudentRepository studentRepository;
    public List<StudentInfo> getAllStudent() {

        return  studentRepository.findAll();
    }
    public Boolean addUser(StudentInfo studentInfo) {
          studentRepository.save(studentInfo);
          return true;
    }
}
