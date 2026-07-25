package kh.edu.ppua.api.service;

import org.springframework.data.domain.Page;

public interface AbstractService<T> {

    Page<T> findAllWithPaginate(String query, int page, int limit);

    T findById(Long id);

    T saveNew(T request);

    T update(Long id, T request);

    T deleteById(Long id);

}
