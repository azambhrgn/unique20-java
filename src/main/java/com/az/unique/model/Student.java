package com.az.unique.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sId;
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
    private String coaching;

    public Student(String firstName, String lastName, String gender, String fatherName, String phone, String stClass, String medium, String school, String board, String address, String area, String coaching) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.fatherName = fatherName;
        this.phone = phone;
        this.stClass = stClass;
        this.medium = medium;
        this.school = school;
        this.board = board;
        this.address = address;
        this.area = area;
        this.coaching = coaching;
    }
}
