package com.schoolManagementSystem.schoolManagementSystem.repository;

import com.schoolManagementSystem.schoolManagementSystem.model.StudentInfo;
import com.schoolManagementSystem.schoolManagementSystem.model.SubjectDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepository extends MongoRepository<SubjectDetails, String> {
    SubjectDetails findSubjectByName(String name);
    List<SubjectDetails> findAll();
    long count();
}
