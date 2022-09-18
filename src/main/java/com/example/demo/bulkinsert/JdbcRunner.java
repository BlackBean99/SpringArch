package com.example.demo.bulkinsert;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Profile("jdbc")
@Component
@AllArgsConstructor
@Slf4j
public class JdbcRunner implements CommandLineRunner {

    private ItemJdbcService itemJdbcService;

    @Value("${rows}")
    private int rows;

    @Override
    public void run(String... args) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("김수민바보");
        List<ItemJdbc> items = new ArrayList<>();
        int N = rows;
        for (int i = 1; i <= N; i++) {
            items.add(new ItemJdbc(null, "NAME_" + i, "DESC_" + i));
        }
        itemJdbcService.saveAll(items);
        long endTime = System.currentTimeMillis();
        log.info("OOO Elapsed: {} secs", ((endTime - startTime) / 1000.0f));
    }
}