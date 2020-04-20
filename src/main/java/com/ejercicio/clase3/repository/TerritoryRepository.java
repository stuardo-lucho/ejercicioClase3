package com.ejercicio.clase3.repository;

import com.ejercicio.clase3.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory,String> {
}
