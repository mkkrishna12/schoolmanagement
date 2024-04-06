package com.schoolManagementSystem.schoolManagementSystem.model;

import lombok.Data;

@Data
public class StudentInfo {
    private String firstName;
    private String lastName;
    private int rollNumber;
    private String address;
    private SubjectDetails subjectDetails;;
}
