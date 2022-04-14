package com.az.unique.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table
@Entity
public class StudentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    private Long sId;
    private String sComment;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date commentDate;
    private String commentBy;

    public StudentComment(Long sId, String sComment, Date commentDate, String commentBy) {
        this.sId = sId;
        this.sComment = sComment;
        this.commentDate = commentDate;
        this.commentBy = commentBy;
    }
}
