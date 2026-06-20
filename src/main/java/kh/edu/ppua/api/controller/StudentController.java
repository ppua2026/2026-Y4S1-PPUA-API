package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.Student;
import kh.edu.ppua.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/students")
@RestController
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(){
        List<Student> studentList = service.getStudents();
        return ResponseEntity.ok(studentList);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        student = service.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}
