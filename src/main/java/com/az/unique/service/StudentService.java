package com.az.unique.service;

import com.az.unique.model.Student;
import com.az.unique.model.StudentComment;
import com.az.unique.model.StudentRequest;
import com.az.unique.repository.CommentRepo;
import com.az.unique.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepo mStudentRepo;
    private final CommentRepo mCommentRepo;
    @Autowired
    public StudentService(StudentRepo repo, CommentRepo commentRepo) {
        mStudentRepo = repo;
        mCommentRepo = commentRepo;
    }

    public Student saveData(StudentRequest student){
        log.info("****Save **** " + student.toString());
        //student.setSId("123");
        var stud = mStudentRepo.save(new Student(student.getFirstName(),student.getLastName(), student.getGender(),
                student.getFatherName(),student.getPhone(),student.getStClass(),student.getMedium(),student.getSchool(),student.getBoard(),student.getAddress(),student.getArea(), student.getCoachig()));
        log.info("****Saved **** " + stud.toString());
        if (student.getComment() != null && student.getComment().length() > 0) {
            log.info("****SaveComment **** " + student.toString());
            saveComment(new StudentComment(stud.getSId(),student.getComment(),student.getCommentDate(),student.getCommentBy()));
        }

        return stud;
    }

    public void saveComment(StudentComment studentComment) {
        log.info("****Saving Comment **** " + studentComment.toString());
        mCommentRepo.save(studentComment);
    }

    public List<StudentComment> getComments(long sid) {
        return mCommentRepo.findBysId(sid);
    }
    public List<Student> getStudents() {
        return mStudentRepo.findAll();
    }

    public Optional<Student> getStudent(long sId) {
        return mStudentRepo.findById(sId);
    }

    public Student updateById(long id, Student newStudent) {
        log.info("****Update **** " + id);
        return mStudentRepo.findById(id)
                .map(p -> {
                    p.setFirstName(newStudent.getFirstName());
                    p.setLastName(newStudent.getLastName());
                    p.setGender(newStudent.getGender());
                    p.setFatherName(newStudent.getFatherName());
                    p.setStClass(newStudent.getStClass());
                    p.setSchool(newStudent.getSchool());
                    p.setMedium(newStudent.getMedium());
                    p.setBoard(newStudent.getBoard());
                    p.setAddress(newStudent.getAddress());
                    p.setArea(newStudent.getArea());
                    p.setCoaching(newStudent.getCoaching());
                    return mStudentRepo.save(p);
                })
                .orElseGet(() -> {
                    newStudent.setSId(id);
                    return mStudentRepo.save(newStudent);
                });
    }

    public void deleteStudent(long sId) {
        mStudentRepo.deleteById(sId);
    }


}
