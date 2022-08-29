package com.example.demo.domain.comment;

import com.example.demo.domain.comment.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @EntityGraph("Comment.fetchPost")
    List<Comment> findByTitle(String title);
}




