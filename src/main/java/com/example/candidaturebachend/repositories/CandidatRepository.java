package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat,String> {

  //  Optional<Candidat> findCandidatById(String id);
  @Query("SELECT c FROM Candidat c JOIN c.diplomes d WHERE d.filiere = :filiere")
  List<Candidat> findByFiliere(@Param("filiere") Filiere filiere);
  @Query("select c from Candidat c where c.nom like :kw")
  List<Candidat> searchCandidats(@Param("kw") String keyword);
}
