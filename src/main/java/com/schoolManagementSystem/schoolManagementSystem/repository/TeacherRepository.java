package com.schoolManagementSystem.schoolManagementSystem.repository;

import com.schoolManagementSystem.schoolManagementSystem.model.StudentInfo;
import com.schoolManagementSystem.schoolManagementSystem.model.TeacherInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository extends MongoRepository<TeacherInfo, String> {
    TeacherInfo findTeacherByfirstName(String firstName);
    List<TeacherInfo> findAll();
    long count();
}
