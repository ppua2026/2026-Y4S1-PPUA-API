package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.LectureEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/teacher")
@RestController
public class LectureController implements IDefaultController<LectureEntity> {

    @Override
    public ResponseEntity<?> findAllWithPaginate(@RequestParam(name = "query", defaultValue = "") String query,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> saveNew(LectureEntity request) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(LectureEntity request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
