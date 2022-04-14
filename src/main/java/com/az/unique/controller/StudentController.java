package com.az.unique.controller;

import com.az.unique.model.Comments;
import com.az.unique.model.Student;
import com.az.unique.model.StudentComment;
import com.az.unique.model.StudentRequest;
import com.az.unique.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    private StudentService mStudentService;

    @Autowired
    public StudentController(StudentService studentService) {
        mStudentService = studentService ;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> save(@RequestBody StudentRequest student) {
        try {
            var std = mStudentService.saveData(student);
            return new ResponseEntity<>(std, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getStudents() {
        try {
            var studetns = mStudentService.getStudents();
            return new ResponseEntity<>(studetns, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id) {
        logger.info("******** " + id);
        Optional<Student> student = mStudentService.getStudent(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update according to consitions- Add prev and new Available quantity
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        logger.info("Student to update : " + student.toString());
        mStudentService.updateById(student.getSId(), student);
        return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
    }

    // Change to mark status of product as DActivate
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
        try {
            mStudentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/comment")
    @CrossOrigin
    public ResponseEntity<?> saveComment(@RequestBody StudentComment comment) {
        logger.info("****Save Comment**** " + comment.toString());
        try {
            mStudentService.saveComment(comment);
            return new ResponseEntity<>("Successful", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comments> getComments(@PathVariable("id") long id) {
        logger.info("****get Comment**** " + id);
        try {
            List<StudentComment> students = mStudentService.getComments(id);
            return new ResponseEntity<>(new Comments(id, students), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
