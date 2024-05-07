package com.schoolManagementSystem.schoolManagementSystem.repository;

import com.schoolManagementSystem.schoolManagementSystem.model.StudentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface StudentRepository extends MongoRepository<StudentInfo, BigInteger> {
     StudentInfo findById(String id);
     List<StudentInfo> findAll();
     StudentInfo save(StudentInfo studentInfo);
     long count();

}
