package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.ChefDepartement;
import com.example.candidaturebachend.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    @Query("Select d from Departement d where d.intitule like :kw")
    List<Departement> searchDepartements(@Param("kw")String key);

    //Optional<Departement> findDepartementById(Integer id);
}
