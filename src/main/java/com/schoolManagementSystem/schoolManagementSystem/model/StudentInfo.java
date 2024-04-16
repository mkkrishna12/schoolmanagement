package com.schoolManagementSystem.schoolManagementSystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection="StudentInfo")
public class StudentInfo {
    @Id
    private BigInteger id;
    private String firstName;
    private String lastName;
    private int rollNumber;
    private String address;
    private String subjectsIds;
//    private String classTeacher;
}
