package com.az.unique.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table
@Entity
public class StudentPic {
    @Id
    private Long sId;
    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    public StudentPic(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
