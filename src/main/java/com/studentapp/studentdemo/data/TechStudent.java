package com.studentapp.studentdemo.data;

public class TechStudent extends Student {
    public TechStudent (int studentId, String name, String studentClass, int age, int studyPoints){
        super(studentId, name, studentClass, age, studyPoints);
        setStudentClass(studentClass);
    }

    @Override
    public void setStudentClass (String StudentClass){

        String temp = studentClass;
            
        String[] result = temp.split(" ",2);
        temp = result[1];

        this.studentClass = "Tech " + temp;
    }
}
