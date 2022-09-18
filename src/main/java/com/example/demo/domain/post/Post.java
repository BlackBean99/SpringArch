package com.example.demo.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {
//    @Id
//    @GenericGenerator(
//            name = "SequenceGenerator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name", value = "hibernate_sequence"),
//                    @Parameter(name = "optimizer", value = "pooled"),
//                    @Parameter(name = "initial_value", value = "1"),
//                    @Parameter(name = "increment_size", value = "500")
//            }
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "SequenceGenerator"
//    )
    @Id
    @GeneratedValue(strategy = IDENTITY) @Column(name = "POST_ID")
    private Long id;

    private String title;

    public Post(String title){
        this.id = this.getId();
        this.title = title;
    }
}
