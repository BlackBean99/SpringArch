package com.example.demo.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJdbcRepository extends JpaRepository<Post,Long> {
}
