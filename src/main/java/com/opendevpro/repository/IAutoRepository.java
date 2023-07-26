package com.opendevpro.repository;
import com.opendevpro.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAutoRepository extends JpaRepository<Auto, Integer> {

    @Query("SELECT a FROM Auto a ORDER BY a.brand ASC")
    List<Auto> ordernarPorORMASC();

    @Query("SELECT a FROM Auto a ORDER BY a.brand DESC")
    List<Auto> ordernarPorORMDESC();
}
