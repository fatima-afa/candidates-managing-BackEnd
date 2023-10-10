package com.example.candidaturebachend.web;

import com.example.candidaturebachend.Exceptions.fileNotFoundException;
import com.example.candidaturebachend.dto.FichierDto;
import com.example.candidaturebachend.servicesDto.serviceImpDto.FichierDtoServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/fichier")
public class FichierController {
    @Autowired
    private FichierDtoServiceImpl fichierService;



    @GetMapping("/all")
    public ResponseEntity<List<FichierDto>> getAllFichiers() {
        List<FichierDto> fichiers = fichierService.listFichier();
        return new ResponseEntity<>(fichiers, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FichierDto> getFichierById(@PathVariable("id") String id) throws fileNotFoundException {
        FichierDto fichier = fichierService.getFichier(id);
        return new ResponseEntity<>(fichier, HttpStatus.OK);
    }

   /* @PostMapping("/add")
    public ResponseEntity<FichierDto> addFichier(@RequestBody FichierDto fichier) {
        FichierDto newFichier = fichierService.saveFichier(fichier);
        return new ResponseEntity<>(newFichier, HttpStatus.CREATED);
    }*/

    /*@PostMapping("/addFile")
    public ResponseEntity<?> uploadFIle(@RequestParam("fichier") MultipartFile file) throws IOException {
        String uploadFile = fichierService.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadFile);
    }*/
    /*@PostMapping("/addFile")
    public ResponseEntity<String> uploadFile(@RequestPart("fichier") MultipartFile file) {
        try {
            ResponseEntity<String> response = fichierService.uploadFile(file);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    @PostMapping("/addFile")
    public ResponseEntity<FichierDto> uploadFile(@RequestPart("fichier") MultipartFile file) {
        try {
            ResponseEntity<FichierDto> response = fichierService.uploadFile(file);
            // Ajoutez cette condition pour vérifier si la réponse est OK
            if (response.getStatusCode() == HttpStatus.OK) {
                FichierDto message = response.getBody();
                return ResponseEntity.ok(message);
            } else {
                // Si la réponse n'est pas OK, renvoyez la même réponse d'erreur du service
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PutMapping("/update")
    public ResponseEntity<FichierDto> updateFichier(@RequestBody FichierDto fichier) {
        FichierDto updateFichier = fichierService.updateFichier(fichier);
        return new ResponseEntity<>(updateFichier, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFichier(@PathVariable("id") String id) {
        fichierService.deleteFichier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
