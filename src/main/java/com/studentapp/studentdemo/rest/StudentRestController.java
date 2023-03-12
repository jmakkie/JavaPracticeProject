package com.studentapp.studentdemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.studentdemo.data.Student;
import com.studentapp.studentdemo.data.TeacherStudent;
import com.studentapp.studentdemo.data.TechStudent;
import com.studentapp.studentdemo.service.StudentService;

@RestController
public class StudentRestController {

    StudentService service;

    @Autowired
    public StudentRestController(StudentService service){
        this.service = service;
    }

    @GetMapping("/studentAmounts")
    public Map<String,Object> getAmount(){
        return service.getStudentAmount();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable int id){
        Student student = service.getOneStudent(id);

        if(student != null){
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        boolean bool = service.addStudent(student);
        
        if(bool == true){
            return "Student added";
        }
        else{
            return "Adding failed";
        }
    }

    @PostMapping("/addTechStudent")
    public String addTechStudent(@RequestBody TechStudent student){
        boolean bool = service.addTechStudent(student);
        
        if(bool == true){
            return "Student added";
        }
        else{
            return "Adding failed";
        }
    }

    @PostMapping("/addTeacherStudent")
    public String addTeacherStudent(@RequestBody TeacherStudent student){
        boolean bool = service.addTeacherStudent(student);
        
        if(bool == true){
            return "Student added";
        }
        else{
            return "Adding failed";
        }
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestBody Student student){
        try{
            service.deleteStudent(student.getStudentId());
            return "Deletion was a success";
        }catch (Exception e){
            return "Deletion failed";
        }
    }
}