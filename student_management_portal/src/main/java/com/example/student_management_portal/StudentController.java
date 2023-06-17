package com.example.student_management_portal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> studentDB = new HashMap<>();
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentDB.put(student.getAdmissionNo(),student);
        return "You have Succesfull ad Student Details";
    }
    @GetMapping("/get_info")
    public Student getStudentDetail(@RequestParam("id") int admissionNo){
        return studentDB.get(admissionNo);
    }
    @GetMapping("/get/{id}/{message}")
    public Student getStudentByPathVariable(@PathVariable("id") int admissionNo){
        return studentDB.get(admissionNo);
    }
    @DeleteMapping("/delet")
    public String deletStudentDetail(@RequestParam("id") int admissionNo){
        if(!studentDB.containsKey(admissionNo)){
            throw new RuntimeException("Student Does'nt Exist");
        }
        studentDB.remove(admissionNo);
        return "You successfull Delet Student Details ";
    }

    @GetMapping("/get_total_student")
    public int getTotalStudent(){

        int total = 0;
        for(int admissionNo : studentDB.keySet()){
            if(studentDB.get(admissionNo).getAge() > 25){
                total++;
            }
        }
        return total;
    }
}
