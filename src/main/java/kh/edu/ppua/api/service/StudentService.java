package kh.edu.ppua.api.service;

import kh.edu.ppua.api.model.Student;
import kh.edu.ppua.api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository repository;

    StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getStudents(){
        return repository.getStudents();
    }

    public Student getStudentById(long id){
        return  repository.getStudentById(id);
    }

    public Student saveStudent(Student student){
        repository.saveStudent(student);
        return student;
    }

}
