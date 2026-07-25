package kh.edu.ppua.api.service;

import kh.edu.ppua.api.model.NewsEntity;
import kh.edu.ppua.api.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsService implements AbstractService<NewsEntity> {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public Page<NewsEntity> findAllWithPaginate(String query, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        return newsRepository.findAll(pageable);
    }

    @Override
    public NewsEntity findById(Long id) {
        return newsRepository.findById(id).orElseThrow(null);
    }

    @Override
    public NewsEntity saveNew(NewsEntity request) {
        return newsRepository.save(request);
    }

    @Override
    public NewsEntity update(Long id, NewsEntity request) {
        Optional<NewsEntity> newsEntityOptional = newsRepository.findById(id);
        if(newsEntityOptional.isPresent()){
            request.setId(id);
            return newsRepository.save(request);
        }
        return null;
    }

    @Override
    public NewsEntity deleteById(Long id) {
        Optional<NewsEntity> newsEntityOptional = newsRepository.findById(id);
        if(newsEntityOptional.isPresent()){
            newsRepository.deleteById(id);
            return newsEntityOptional.get();
        }
        return null;
    }
}
