package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.SubjectEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/subject")
@RestController
public class SubjectController implements IDefaultController<SubjectEntity> {

    @GetMapping
    @Override
    public ResponseEntity<?> findAllWithPaginate(@RequestParam(name = "query", defaultValue = "") String query,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return null;
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<?> saveNew(SubjectEntity request) {
        return null;
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> update(SubjectEntity request, @PathVariable(name = "id") Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        return null;
    }
}
