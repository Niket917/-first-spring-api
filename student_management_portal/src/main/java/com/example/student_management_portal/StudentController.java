package com.example.student_management_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService ;

    @GetMapping("/get_info")
    public ResponseEntity getStudentDetail(@RequestParam("id") int admissionNo){
        Student s = studentService.getStudent(admissionNo);
        if(s == null){
            return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(s,HttpStatus.FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }
   @GetMapping("/get/{id}/{message}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int admissionNo, @PathVariable("message") String message){
        String str = studentService.getStudentByPathVariable(admissionNo, message);
        if(str == null){
            return new ResponseEntity<>("Student Don't exist",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(str,HttpStatus.FOUND);
        }
   }
   @DeleteMapping("/delet")
    public ResponseEntity deletStudent(@RequestParam("id") int admissionNo){
        int a = studentService.deletStudent(admissionNo);
        if(a == 0) {
            return new ResponseEntity<>("Student Does,nt exists" ,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity("Student Delet SuccessFul", HttpStatus.FOUND);
        }

   }
   @GetMapping("/get_total_student")
    public ResponseEntity getTotalStudent(){
        return new ResponseEntity(studentService.getTotalStudent(),HttpStatus.FOUND);
   }




}
