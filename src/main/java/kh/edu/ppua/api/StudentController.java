package kh.edu.ppua.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(value = "/api/student")
@RestController
public class StudentController {


    // Constructor Injection
//    private final StudentService service;
//
//    public StudentController(StudentService service) {
//        this.service = service;
//    }

    // Field Injection
//    @Autowired
//    private StudentService service;


    // Method Injection
    private StudentService service;
    @Autowired
    public void setStudentService(StudentService service){
       this.service = service;
    }
    
    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public Map<String,String> getStudent(){
        return service.getStudent();
    }

}
