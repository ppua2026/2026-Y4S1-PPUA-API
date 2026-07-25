package kh.edu.ppua.api.service;

import kh.edu.ppua.api.model.CategoryEntity;
import kh.edu.ppua.api.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements AbstractService<CategoryEntity> {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<CategoryEntity> findAllWithPaginate(String query, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        return categoryRepository.findAll(pageable);
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(null);
    }

    @Override
    public CategoryEntity saveNew(CategoryEntity request) {
        return categoryRepository.save(request);
    }

    @Override
    public CategoryEntity update(Long id, CategoryEntity request) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if(category.isPresent()){
            request.setId(id);
            return categoryRepository.save(request);
        }
        return null;
    }

    @Override
    public CategoryEntity deleteById(Long id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.deleteById(id);
            return category.get();
        }
        return null;
    }
}
