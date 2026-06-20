package kh.edu.ppua.api.repository;

import kh.edu.ppua.api.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudents(){
        return studentList;
    }

    public void saveStudent(Student student){
        studentList.add(student);
    }

}
