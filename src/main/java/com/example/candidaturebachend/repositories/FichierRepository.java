package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FichierRepository extends JpaRepository<Fichier, String> {

 //   Optional<Fichier> findFichierById(String id);
}
