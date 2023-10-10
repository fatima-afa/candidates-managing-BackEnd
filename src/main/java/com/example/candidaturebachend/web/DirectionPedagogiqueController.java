/*package com.example.candidaturebachend.web;

import com.example.candidaturebachend.entities.DirectionPedagogique;
import com.example.candidaturebachend.repositories.DirectionPedagogiqueRepository;
import com.example.candidaturebachend.services.servicesImpl.DirectionPedagogiqueServiceImpl;
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
@RequestMapping("/directionPedagogique")
public class DirectionPedagogiqueController {
    @Autowired
    private DirectionPedagogiqueServiceImpl directionPedagogiqueService;
    @Autowired
    DirectionPedagogiqueRepository directionPedagogiqueRepo;


    @GetMapping("/all")
    public ResponseEntity<List<DirectionPedagogique>> getAllDirectionPedagogiques() {
        List<DirectionPedagogique> directionPedagogiques = directionPedagogiqueService.findAllDirectionPedagogiques();
        return new ResponseEntity<>(directionPedagogiques, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DirectionPedagogique> getDirectionPedagogiqueById(@PathVariable("id") Integer id) {
        DirectionPedagogique directionPedagogique = directionPedagogiqueService.findDirectionPedagogiqueById(id);
        return new ResponseEntity<>(directionPedagogique, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DirectionPedagogique> addDirectionPedagogique(@RequestBody DirectionPedagogique directionPedagogique) {
        DirectionPedagogique newDirectionPedagogique = directionPedagogiqueService.addDirectionPedagogique(directionPedagogique);
        return new ResponseEntity<>(newDirectionPedagogique, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DirectionPedagogique> updateDirectionPedagogique(@RequestBody DirectionPedagogique directionPedagogique) {
        DirectionPedagogique updateDirectionPedagogique = directionPedagogiqueService.updateDirectionPedagogique(directionPedagogique);
        return new ResponseEntity<>(updateDirectionPedagogique, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirectionPedagogique(@PathVariable("id") Integer id) {
        directionPedagogiqueService.deleteDirectionPedagogique(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
*/