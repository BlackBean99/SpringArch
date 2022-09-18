package com.example.demo.domain.post;

import com.example.demo.bulkinsert.ItemJdbc;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Value("${rows}")
    private int rows;

    @PostMapping("/api/clock/")
    public void bulkInsert(){
        long startTime = System.currentTimeMillis();
        log.info("김수민바보");
        List<Post> items = new ArrayList<>();
        int N = rows;
        for (int i = 1; i <= N; i++) {
            items.add(new Post(String.valueOf(i)));
        }
        postService.saveAll(items);
        long endTime = System.currentTimeMillis();
        log.info("OOO Elapsed: {} secs", ((endTime - startTime) / 1000.0f));
    }
}
