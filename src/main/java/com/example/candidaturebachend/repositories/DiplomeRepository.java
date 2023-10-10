package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {
   // public List<Diplome> findAll();
    //Optional<Diplome> findDiplomeById(Integer id);
    List<Diplome> findAllByCandidat_Cin(String cin);
    Diplome findDiplomeByCandidat(Candidat candidat);
}
