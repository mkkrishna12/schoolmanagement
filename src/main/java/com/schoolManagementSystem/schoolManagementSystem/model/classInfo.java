package com.schoolManagementSystem.schoolManagementSystem.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collation = "classInfo")
public class classInfo {
    @Id
    private BigInteger id;
    private String classTeacherId;
    private int classNumber;
    private String[] studentIds;
    private String academicYear;
    private String[] subjectsToTeach;
    private String[] teacherIds;
}
