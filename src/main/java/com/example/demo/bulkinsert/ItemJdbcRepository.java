package com.example.demo.bulkinsert;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemJdbcRepository {
    void saveAll(List<ItemJdbc> items);
}