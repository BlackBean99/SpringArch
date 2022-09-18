package com.example.demo.bulkinsert;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Profile("jdbc")
@Transactional
@Service
@RequiredArgsConstructor
public class ItemJdbcService {
    private final ItemJdbcRepositoryImpl repository;
    public void saveAll(List<ItemJdbc> items) {
        repository.saveAll(items);
    }
}