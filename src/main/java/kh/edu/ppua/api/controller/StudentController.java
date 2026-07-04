package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.Student;
import kh.edu.ppua.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/v1/students")
@RestController
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping( "")
    public ResponseEntity<?> getStudent(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "10") int limit
    ){
        System.out.println("Page : "+page);
        System.out.println("Limit : "+limit);
        List<Student> studentList = service.getStudents();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id){
        System.out.println("Id : "+id);
        System.out.printf("%s%s%s%n", "id"," : " ,id);
        Student student = service.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping()
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        student = service.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

//    @GetMapping("/{id}/profile")
//    public ResponseEntity<?> getStudentProfile(){
//
//    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<?> uploadProfile(
            @RequestHeader("User-Agent") String userAgent,
            @RequestParam MultipartFile file){
        System.out.println("UserAgent : "+ userAgent);
        System.out.println("File Name : "+ file.getOriginalFilename());
        return ResponseEntity.ok(file.getOriginalFilename());
    }

}
