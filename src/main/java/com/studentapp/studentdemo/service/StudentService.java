package com.studentapp.studentdemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.studentapp.studentdemo.data.*;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService(){
            students.add(new Student(1,"Jarkko M", "7b", 99, 0));
            students.add(new Student(2,"Pekka P", "3a", 9, 100));
            students.add(new TechStudent(3,"Veikka K", "90c", 0, 1));
            students.add(new TeacherStudent(4,"Kalle K", "7b", 2, 7));
    }

    public boolean addStudent(Student student){
        try{
            students.add(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addTechStudent(TechStudent student){
        try{
            students.add(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean addTeacherStudent(TeacherStudent student){
        try{
            students.add(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Student> getAllStudents(){
        return new ArrayList<>(students);
    }

    public Student getOneStudent(int id){
        for(Student s : students) {
            if(s.getStudentId() == id){
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id){
        Student p = getOneStudent(id);

        if(p != null){
            students.remove(p);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Object> getStudentAmount(){
        Map<String, Object> amounts = new HashMap<>();

        amounts.put("Total: ", students.size());
        
        int techStudent = 0, teacherStudent = 0, normalStudent = 0, other = 0;
        for (Student student : students){
            String temp = student.getStudentClass();
            
            String[] result = temp.split(" ");
            temp = result[0];

            if(temp.contains("Tech")) techStudent++;
            else if(temp.contains("Teacher")) teacherStudent++;
            else if(temp.contains("normal")) normalStudent++;
            else{ other++; }
        }

        amounts.put("tech students: ", techStudent);
        amounts.put("teacher students: ", teacherStudent);
        amounts.put("normal students: ", normalStudent);
        amounts.put("other students: ", other);

        return amounts;
    }
}