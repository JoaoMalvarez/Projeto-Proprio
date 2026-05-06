package com.rpg.repository;

import com.rpg.model.Substatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubstatusRepository extends JpaRepository<Substatus, Long> {
    List<Substatus> findByCategoria(String categoria);
}