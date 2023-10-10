package com.example.candidaturebachend.web;

import com.example.candidaturebachend.Exceptions.DepartementNotFoundException;
import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.DepartementDto;
import com.example.candidaturebachend.entities.Departement;
import com.example.candidaturebachend.repositories.DepartementRepository;
import com.example.candidaturebachend.servicesDto.serviceImpDto.DepartementDtoServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RestController
@RequestMapping("/departement")
public class DepartementController {
    private DepartementDtoServiceImpl departementService;




    @GetMapping("/all")
    public ResponseEntity<List<DepartementDto>> getAllDepartements() {
        List<DepartementDto> departements = departementService.listDepartements();
        return new ResponseEntity<>(departements, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DepartementDto>> searchDepartement(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        List<DepartementDto> departementDtos = departementService.searchDepartements("%"+keyword+"%");
        return new ResponseEntity<>(departementDtos, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable("id") Integer id) throws DepartementNotFoundException {
        DepartementDto departement = departementService.getDepartement(id);
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DepartementDto> addDepartement(@RequestBody DepartementDto departement) {
        DepartementDto newDepartement = departementService.savedepartement(departement);
        return new ResponseEntity<>(newDepartement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DepartementDto> updateDepartement(@RequestBody DepartementDto departement) {
        DepartementDto updateDepartement = departementService.updateDepartement(departement);
        return new ResponseEntity<>(updateDepartement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartement(@PathVariable("id") Integer id) {
        departementService.deletDepartement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
