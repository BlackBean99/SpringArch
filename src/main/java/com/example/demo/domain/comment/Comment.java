package com.example.demo.domain.comment;

import com.example.demo.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private Post post;

    public Comment(String title, Post post){
        this.title = title;
        this.post = post;
    }

}
