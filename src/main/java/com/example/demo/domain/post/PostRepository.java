package com.example.demo.domain.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    @EntityGraph("Post.fetchPost")
    Optional<Post> findById(Long id);
}
