package com.example.student_management_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int admissionNo){
        return studentRepository.getStudent(admissionNo);

    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String getStudentByPathVariable(int admissionNo, String message) {
        return studentRepository.getStudentByPathVariable(admissionNo,message);
    }
    public int deletStudent(int admissionNo){
        return studentRepository.deletStudent(admissionNo);
    }

    public int getTotalStudent() {
        return studentRepository.getTotalStudent();
    }
}
