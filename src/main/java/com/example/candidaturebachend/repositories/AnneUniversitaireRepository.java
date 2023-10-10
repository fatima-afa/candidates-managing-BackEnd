package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.AnneUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnneUniversitaireRepository extends JpaRepository<AnneUniversitaire,Integer> {
    Optional<AnneUniversitaire> findAnneUniversitaireById(Integer id);
}
