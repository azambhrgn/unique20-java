package com.az.unique.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Comments {
    long sid;
    List<StudentComment> comments;
}
