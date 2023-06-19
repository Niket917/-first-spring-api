package com.example.student_management_portal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> studentDB = new HashMap<>();

    public Student getStudent(int admissionNo){
        return studentDB.get(admissionNo);
    }

    public String addStudent(Student student) {
        if(studentDB.containsKey(student.getAdmissionNo())){
            return "Student Detail Aready Exist";
        } else {
            studentDB.put(student.getAdmissionNo(), student);
            return "Student Detail add Successful";
        }
    }

    public String getStudentByPathVariable(int admissionNo, String message) {
        Student s = studentDB.get(admissionNo);
         return s + message;
    }
    public int deletStudent(int admissionNo){
        if(!studentDB.containsKey(admissionNo)){
            return 0;
        } else {
            studentDB.remove(admissionNo);
            return 1;
        }
    }

    public int getTotalStudent() {
        int total = 0;
        for(int admissionNo : studentDB.keySet()){
            if(studentDB.get(admissionNo).getAge() > 22){
                total++;
            }
        }
        return total;
    }
}
