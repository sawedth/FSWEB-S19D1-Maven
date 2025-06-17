package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query(value = "SELECT v.* FROM Vegetable v ORDER v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.* FROM Vegetable v ORDER v.price ASC", nativeQuery = true)
    List<Vegetable> sortAsc();

    @Query(value = "SELECT v FROM Vegetable v WHERE name ILIKE '%:name%'")
    List<Vegetable> findName(String name);
}
