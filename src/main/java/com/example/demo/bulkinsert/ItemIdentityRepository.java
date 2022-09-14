package com.example.demo.bulkinsert;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemIdentityRepository extends JpaRepository<ItemIdentity, Long> {
}