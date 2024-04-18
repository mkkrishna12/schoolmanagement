package com.schoolManagementSystem.schoolManagementSystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Teacherinfo")
public class TeacherInfo {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String[] subjects;
    private String degree;
    private String contactDetails;
    private String joiningDate;
}
