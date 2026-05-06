package com.rpg.repository;

import com.rpg.model.InventarioItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<InventarioItem, Long> {}