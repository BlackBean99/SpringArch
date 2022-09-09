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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

@Entity
@Getter
@NoArgsConstructor
@NamedEntityGraph(name="Comment.fetchPost", attributeNodes = @NamedAttributeNode("post"))
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne
    private Post post;

    public Comment(String comment, Post post){
        this.comment = comment;
        this.post = post;
    }
}
