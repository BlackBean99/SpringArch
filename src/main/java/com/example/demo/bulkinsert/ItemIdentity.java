package com.example.demo.bulkinsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemIdentity {
        @Id
        @GenericGenerator(
                name = "SequenceGenerator",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters = {
                        @Parameter(name = "sequence_name", value = "hibernate_sequence"),
                        @Parameter(name = "optimizer", value = "pooled"),
                        @Parameter(name = "initial_value", value = "1"),
                        @Parameter(name = "increment_size", value = "500")
                }
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "SequenceGenerator"
        )
        private Long id;
        private String name;
        private String description;
    }