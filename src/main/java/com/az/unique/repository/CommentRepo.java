package com.az.unique.repository;

import com.az.unique.model.Student;
import com.az.unique.model.StudentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<StudentComment, Long> {
    List<StudentComment> findBysId(long sId);
}
