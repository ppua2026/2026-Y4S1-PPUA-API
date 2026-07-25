package kh.edu.ppua.api.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kh.edu.ppua.api.model.NewsEntity;
import kh.edu.ppua.api.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/news")
@RestController
public class NewsController implements IDefaultController<NewsEntity>{

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> findAllWithPaginate(@RequestParam(name = "query", defaultValue = "") String query,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        Page<NewsEntity> newsEntityPage = newsService.findAllWithPaginate(query, page, limit);
        return new ResponseEntity<>(newsEntityPage, HttpStatus.OK);
    }

    @GetMapping( "/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable Long id) {
        NewsEntity newsEntity = newsService.findById(id);
        return new ResponseEntity<>(newsEntity, HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> saveNew(@RequestBody NewsEntity request) {
        request.setTitle("ABC");
        request.setContent("XYZ");
        NewsEntity newsEntity = newsService.saveNew(request);
        return new ResponseEntity<>(newsEntity, HttpStatus.OK);
    }

    @PutMapping( "/{id}")
    @Override
    public ResponseEntity<?> update(@RequestBody  NewsEntity request, @PathVariable Long id) {
        NewsEntity newsEntity = newsService.update(id, request);
        return new ResponseEntity<>(newsEntity, HttpStatus.OK);
    }

    @DeleteMapping( "/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        NewsEntity newsEntity = newsService.deleteById(id);
        return new ResponseEntity<>(newsEntity, HttpStatus.OK);
    }
}
