package com.example.demo.domain.comment;

import com.example.demo.domain.comment.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @EntityGraph("Comment.fetchPost")
    List<Comment> findByComment(String title);

    @EntityGraph("Comment.fetchPost")
    Optional<Comment> findById(Long id);

    @EntityGraph("Comment.fetchPost")
    Comment findOneByComment(String title);

}




