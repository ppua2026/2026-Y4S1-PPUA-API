package kh.edu.ppua.api.repository;

import kh.edu.ppua.api.model.Student;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudents(){
        return studentList;
    }

    public Student getStudentById(Long id){
     Optional<Student> student = studentList.stream().filter((s)-> s.getId() == id).findFirst();
        return student.orElse(null);
    }

    public void saveStudent(Student student){
        studentList.add(student);
    }

}
