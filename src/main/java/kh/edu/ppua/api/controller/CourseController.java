package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.dto.CourseCreateRequest;
import kh.edu.ppua.api.dto.CourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/course")
@RestController
public class CourseController implements IDefaultController<CourseRequest>{

    @Override
    public ResponseEntity<?> findAllWithPaginate(@RequestParam(name = "query", defaultValue = "") String query,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> saveNew(CourseRequest request) {
        CourseCreateRequest courseCreateRequest = (CourseCreateRequest) request;
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> update(CourseRequest request) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return ResponseEntity.ok().build();
    }
}
