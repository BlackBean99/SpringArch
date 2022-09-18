package com.example.demo.domain.post;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostJdbcRepository repository;

    public void saveAll(List<Post> items) {
        repository.saveAll(items);
    }
}
