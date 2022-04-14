package com.az.unique.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String fatherName;
    private String phone;
    private String stClass;
    private String medium;
    private String school;
    private String board;
    private String address;
    private String area;
    private String comment;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date commentDate;
    private String commentBy;
    private String coachig;
}
