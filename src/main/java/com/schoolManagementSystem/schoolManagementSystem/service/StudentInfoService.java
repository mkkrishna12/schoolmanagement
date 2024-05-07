package com.schoolManagementSystem.schoolManagementSystem.service;

//import com.schoolManagementSystem.schoolManagementSystem.exception.ClientErrorException;
import com.schoolManagementSystem.schoolManagementSystem.exception.ClientErrorException;
import com.schoolManagementSystem.schoolManagementSystem.exception.ServerErrorExceptionHandler;
import com.schoolManagementSystem.schoolManagementSystem.model.*;
import com.schoolManagementSystem.schoolManagementSystem.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.schoolManagementSystem.schoolManagementSystem.utilities.ExceptionMessages;
import java.util.List;
@Service
public class StudentInfoService {
    private static final Logger log = LoggerFactory.getLogger(StudentInfoService.class);
    @Autowired
    private StudentRepository studentRepository;
    public StudentInfo getStudentById(String id) throws Exception {
        try {
            StudentInfo studentInfo = studentRepository.findById(id);
            if(studentInfo == null){
                log.info(ExceptionMessages.STUDENT_NOT_FOUND+id);
                throw new ClientErrorException(ExceptionMessages.STUDENT_NOT_FOUND+id, HttpStatus.NOT_FOUND);
            }
            return  studentInfo;
        } catch (Exception ex) {
            log.error("[ERROR] : {}", ex.getMessage());
            throw new ServerErrorExceptionHandler(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<StudentInfo> getAllStudent() {
        try {
            List<StudentInfo> studentInfos =  studentRepository.findAll();
            return studentInfos;
        } catch (Exception e) {
            throw new ServerErrorExceptionHandler(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public StudentInfo addUser(StudentInfo studentInfo) {
          try {
              StudentInfo studentInfo1 = studentRepository.save(studentInfo);
              if (studentInfo1 == null){
                  throw new ServerErrorExceptionHandler("Recode has not been added", HttpStatus.INTERNAL_SERVER_ERROR);
              }
              return studentInfo1;
          } catch (Exception e){
              throw new ServerErrorExceptionHandler(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
}
