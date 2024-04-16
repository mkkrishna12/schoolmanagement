package com.schoolManagementSystem.schoolManagementSystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("subjectinfo")
public class SubjectDetails {
    @Id
    private String id;
    private String name;
    private String teacher;
    private String students;
}
