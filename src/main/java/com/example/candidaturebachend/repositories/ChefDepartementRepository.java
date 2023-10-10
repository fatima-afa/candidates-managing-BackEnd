package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.ChefDepartement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefDepartementRepository extends JpaRepository<ChefDepartement,String> {

   // Optional<ChefDepartement> findChefDepartementById(String id);
}
