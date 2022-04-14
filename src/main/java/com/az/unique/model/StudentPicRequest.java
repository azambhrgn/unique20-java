package com.az.unique.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentPicRequest {
    private Long sId;
    private MultipartFile sImage;
}
