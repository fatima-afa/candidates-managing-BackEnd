/*package com.example.candidaturebachend.web;

import com.example.candidaturebachend.entities.AnneUniversitaire;
import com.example.candidaturebachend.repositories.AnneUniversitaireRepository;
import com.example.candidaturebachend.services.servicesImpl.AnneUniversitaireServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;*/
/*
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/anneUniversitaire")
public class AnneUniversitaireController {
    @Autowired
    private AnneUniversitaireServiceImpl anneUniversitaireService;
    @Autowired
    AnneUniversitaireRepository anneUniversitaireRepo;


    @GetMapping("/all")
    public ResponseEntity<List<AnneUniversitaire>> getAllAnneUniversitaires() {
        List<AnneUniversitaire> anneUniversitaires = anneUniversitaireService.findAllAnneUniversitaires();
        return new ResponseEntity<>(anneUniversitaires, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AnneUniversitaire> getAnneUniversitaireById(@PathVariable("id") Integer id) {
        AnneUniversitaire anneUniversitaire = anneUniversitaireService.findAnneUniversitaireById(id);
        return new ResponseEntity<>(anneUniversitaire, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AnneUniversitaire> addAnneUniversitaire(@RequestBody AnneUniversitaire anneUniversitaire) {
        AnneUniversitaire newAnneUniversitaire = anneUniversitaireService.addAnneUniversitaire(anneUniversitaire);
        return new ResponseEntity<>(newAnneUniversitaire, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AnneUniversitaire> updateAnneUniversitaire(@RequestBody AnneUniversitaire anneUniversitaire) {
        AnneUniversitaire updateAnneUniversitaire = anneUniversitaireService.updateAnneUniversitaire(anneUniversitaire);
        return new ResponseEntity<>(updateAnneUniversitaire, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnneUniversitaire(@PathVariable("id") Integer id) {
        anneUniversitaireService.deleteAnneUniversitaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
*/