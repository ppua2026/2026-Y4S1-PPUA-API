package kh.edu.ppua.api;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    public Map<String,String> getStudent(){
        Map<String,String> student = new HashMap<>();
        student.put("id","001");
        student.put("name","sok soa");
        student.put("gender","male");
        return  student;
    }

}
