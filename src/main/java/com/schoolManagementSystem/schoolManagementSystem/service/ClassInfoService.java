package com.schoolManagementSystem.schoolManagementSystem.service;

import com.schoolManagementSystem.schoolManagementSystem.repository.ClassInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ClassInfoService {
    @Autowired
    private ClassInfoRepository classInfoRepository;

    public Optional<ClassInfo> getClassInfo(BigInteger id){
        Optional<ClassInfo> classInfo = classInfoRepository.findById(id);
        return classInfo;
    }

    public List<ClassInfo> getClassInfoForAllClass(){
        return classInfoRepository.findAll();
    }

    public boolean updateClassInfo(ClassInfo classInfo){
        classInfoRepository.save(classInfo);
        return true;
    }
}
