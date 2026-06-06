package kh.edu.ppua.api;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository repository;

    StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public Map<String,String> getStudent(){
        return repository.getStudent();
    }

}
