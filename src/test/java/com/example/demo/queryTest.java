package com.example.demo;

import com.example.demo.domain.comment.Comment;
import com.example.demo.domain.comment.CommentRepository;
import com.example.demo.domain.post.Post;
import com.example.demo.domain.post.PostRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class queryTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;
    @AfterEach
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void PostRepositoryTest(){
        Post p1 = new Post("p1");
        Post p2 = new Post("p2");
        Post p3 = new Post("p3");

        postRepository.save(p1);
        postRepository.save(p2);
        postRepository.save(p3);

        postRepository.flush();

        Comment c1 = new Comment("c1",p1);
        Comment c2 = new Comment("c1",p2);
        Comment c3 = new Comment("c1",p3);

        Comment save = commentRepository.save(c1);
        commentRepository.save(c2);
        commentRepository.save(c3);

        commentRepository.flush();

        Comment comment = commentRepository.findById(save.getId()).get();

        Assertions.assertThat(comment.getTitle()).isEqualTo("c1");

    }

}
