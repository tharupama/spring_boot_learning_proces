package com.kingJava.demo.repo;

import com.kingJava.demo.entity.Item;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {

    List<Item> findAllByItemNameEqualsAndActiveEquals(String itemName, boolean active);

    List<Item> findAllByActive(boolean active);

    List<Item> findAllByActiveEquals(boolean active);

    Page<Item> findAllByActiveEquals(boolean active, Pageable pageable);

    long countAllByActiveEquals(boolean activeStatus);
}
