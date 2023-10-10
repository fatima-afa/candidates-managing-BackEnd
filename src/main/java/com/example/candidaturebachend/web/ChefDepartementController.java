/*package com.example.candidaturebachend.web;

import com.example.candidaturebachend.entities.ChefDepartement;
import com.example.candidaturebachend.repositories.ChefDepartementRepository;
import com.example.candidaturebachend.services.servicesImpl.ChefDepartementServiceImpl;
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
@RequestMapping("/chefDepartement")
public class ChefDepartementController {
    @Autowired
    private ChefDepartementServiceImpl chefDepartementService;
    @Autowired
    ChefDepartementRepository chefDepartementRepo;


    @GetMapping("/all")
    public ResponseEntity<List<ChefDepartement>> getAllChefDepartements() {
        List<ChefDepartement> chefDepartements = chefDepartementService.findAllChefDepartements();
        return new ResponseEntity<>(chefDepartements, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ChefDepartement> getChefDepartementById(@PathVariable("id") String id) {
        ChefDepartement chefDepartement = chefDepartementService.findChefDepartementById(id);
        return new ResponseEntity<>(chefDepartement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ChefDepartement> addChefDepartement(@RequestBody ChefDepartement chefDepartement) {
        ChefDepartement newChefDepartement = chefDepartementService.addChefDepartement(chefDepartement);
        return new ResponseEntity<>(newChefDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ChefDepartement> updateChefDepartement(@RequestBody ChefDepartement chefDepartement) {
        ChefDepartement updateChefDepartement = chefDepartementService.updateChefDepartement(chefDepartement);
        return new ResponseEntity<>(updateChefDepartement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChefDepartement(@PathVariable("id") String id) {
        chefDepartementService.deleteChefDepartement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
*/