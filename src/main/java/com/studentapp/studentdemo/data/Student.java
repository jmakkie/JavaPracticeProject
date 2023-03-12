package com.studentapp.studentdemo.data;

public class Student {
    protected int studentId;
    protected String name;
    protected String studentClass;
    protected int age;
    protected int studyPoints;

    public Student(int studentId, String name, String studentClass, int age, int studyPoints){
        this.studentId=studentId;
        this.name = name;
        this.studentClass = "normal " + studentClass;
        this.age = age;
        this.studyPoints = studyPoints;
    }

    //setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = "normal " + studentClass;
    }
    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }


    //getters
    public int getStudentId() {
        return studentId;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public int getStudyPoints() {
        return studyPoints;
    }
}
