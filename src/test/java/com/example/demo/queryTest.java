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

import java.util.List;
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
        System.out.println("======================PostSave====================");

        postRepository.save(p1);
        postRepository.save(p2);

        postRepository.flush();
        System.out.println("======================CommentSave====================");

        Comment c1 = new Comment("c1",p1);
        Comment c2 = new Comment("b",p2);

        Comment save = commentRepository.save(c1);
        commentRepository.save(c2);

        commentRepository.flush();

//        System.out.println("======================ById====================");
//        Comment commentk = commentRepository.findById(save.getId()).get();

        System.out.println("======================OneByComment====================");
        List<Comment> comments = commentRepository.findByComment("b");
        System.out.println(comments.size() == 2);


        System.out.println("======================OneByComment====================");
        Comment comment = commentRepository.findOneByComment("b");
        System.out.println(comment != null);
    }
}
