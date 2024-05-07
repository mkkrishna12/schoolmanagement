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


    public List<SubjectDetails> getAllSubjects() throws Exception{
        try {
            return  subjectRepository.findAll();
        }catch (Exception e){
            throw e;
        }
    }
    public SubjectDetails getSubjectDetails(String id) throws Exception{
       try {
           return subjectRepository.findSubjectById(id);
       }catch (Exception e){
           throw e;
       }
    }
    public SubjectDetails addSubject(SubjectDetails subjectDetails) throws Exception{
        try {
            return subjectRepository.save(subjectDetails);
        }catch (Exception e){
            throw e;
        }
    }
}
