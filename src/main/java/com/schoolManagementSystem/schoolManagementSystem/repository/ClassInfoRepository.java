package com.schoolManagementSystem.schoolManagementSystem.repository;


import org.springframework.cglib.core.ClassInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClassInfoRepository extends MongoRepository<ClassInfo, BigInteger> {

    Optional<ClassInfo> findById(BigInteger id);
    List<ClassInfo> findAll();
    @Override
    ClassInfo save(ClassInfo classInfo);
}
