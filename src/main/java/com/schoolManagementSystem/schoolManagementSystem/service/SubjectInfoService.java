package com.schoolManagementSystem.schoolManagementSystem.service;

import com.schoolManagementSystem.schoolManagementSystem.model.StudentInfo;
import com.schoolManagementSystem.schoolManagementSystem.model.SubjectDetails;
import com.schoolManagementSystem.schoolManagementSystem.repository.StudentRepository;
import com.schoolManagementSystem.schoolManagementSystem.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectInfoService {
    private static final Logger log = LoggerFactory.getLogger(StudentInfoService.class);
    @Autowired
    private SubjectRepository subjectRepository;


    public List<SubjectDetails> getAllSubjects() {
        return  subjectRepository.findAll();
    }
    public SubjectDetails getSubjectDetails(String id){
        return subjectRepository.findSubjectById(id);
    }
    public SubjectDetails addSubject(SubjectDetails subjectDetails) {
        return subjectRepository.save(subjectDetails);
    }
}
