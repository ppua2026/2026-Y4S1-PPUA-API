package kh.edu.ppua.api.controller;

import org.springframework.http.ResponseEntity;

public interface IDefaultController<T> {

    ResponseEntity<?> findAllWithPaginate(String query, int page, int limit);

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> saveNew(T request);

    ResponseEntity<?> update(T request, Long id);

    ResponseEntity<?> deleteById(Long id);

}
