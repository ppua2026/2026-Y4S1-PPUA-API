package kh.edu.ppua.api.controller;

import kh.edu.ppua.api.model.CategoryEntity;
import kh.edu.ppua.api.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/category")
@RestController
public class CategoryController implements IDefaultController<CategoryEntity>{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> findAllWithPaginate(@RequestParam(name = "query", defaultValue = "") String query,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        Page<CategoryEntity> categoryEntityPage = categoryService.findAllWithPaginate(query, page, limit);
        return new ResponseEntity<>(categoryEntityPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CategoryEntity categoryEntity = categoryService.findById(id);
        return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> saveNew(@RequestBody CategoryEntity request) {
        CategoryEntity categoryEntity = categoryService.saveNew(request);
        return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<?> update(@RequestBody CategoryEntity request, @PathVariable Long id) {
        CategoryEntity categoryEntity = categoryService.update(id, request);
        return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        CategoryEntity categoryEntity = categoryService.deleteById(id);
        return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
    }
}
