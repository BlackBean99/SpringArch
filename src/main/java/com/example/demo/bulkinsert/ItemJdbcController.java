package com.example.demo.bulkinsert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemJdbcController {
//    RequiredArgsConstructor로 생성사 DI
//    private final ItemJdbcService itemJdbcService;

    @Value("${rows}")
    private int rows;

    @PostMapping("/api/itemJdbc/")
    public void bulkInsert(){
        long startTime = System.currentTimeMillis();
        List<ItemJdbc> items = new ArrayList<>();
        int N = rows;
        for (int i = 1; i <= N; i++) {
            items.add(new ItemJdbc(null, "NAME_" + i, "DESC_" + i));
        }
//        itemJdbcService.saveAll(items);
        long endTime = System.currentTimeMillis();
        log.info("OOO Elapsed: {} secs", ((endTime - startTime) / 1000.0f));
    }

}
