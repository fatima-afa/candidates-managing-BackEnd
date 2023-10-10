package com.example.candidaturebachend.web;

import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.DiplomeDto;
import com.example.candidaturebachend.dto.FichierDto;
import com.example.candidaturebachend.entities.Diplome;
import com.example.candidaturebachend.repositories.DiplomeRepository;
import com.example.candidaturebachend.servicesDto.serviceImpDto.DiplomeDtoServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Data
@Builder
@AllArgsConstructor
@RestController
@RequestMapping("/diplome")
//@CrossOrigin
public class DiplomeController {
    private DiplomeDtoServiceImpl diplomeService;
    DiplomeRepository diplomeRepo;


    @GetMapping("/all")

    public ResponseEntity<List<DiplomeDto>> getAllDiplomes() {
        List<DiplomeDto> diplomes = diplomeService.listDiplomes();
        return new ResponseEntity<>(diplomes, HttpStatus.OK);

    }
    @GetMapping("/allCandidatures/{cin}")
    public ResponseEntity<List<DiplomeDto>> getAllCandidatures(@PathVariable("cin") String cin) {
        List<DiplomeDto> diplomes = diplomeService.listCandidatureByCin(cin);
        return new ResponseEntity<>(diplomes, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DiplomeDto> getDiplomeById(@PathVariable("id") Integer id) {
        DiplomeDto diplome = diplomeService.getDiplome(id);
        return new ResponseEntity<>(diplome, HttpStatus.OK);
    }

    @GetMapping("/diplomes/{idCandidat}")
    public ResponseEntity<DiplomeDto> getDiplomeByCandidat(@PathVariable String idCandidat) {
        CandidatDto candidatDto = new CandidatDto();
        candidatDto.setId(idCandidat);
        DiplomeDto diplome = diplomeService.getDiplomeByCandidat(candidatDto);
        return new ResponseEntity<>(diplome, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DiplomeDto> addDiplome(@RequestBody DiplomeDto diplome) {
        DiplomeDto newDiplome = diplomeService.saveDiplome(diplome);
        return new ResponseEntity<>(newDiplome, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DiplomeDto> updateDiplome(@RequestBody DiplomeDto diplome, CandidatDto candidatDto, FichierDto fichierDto) {
        DiplomeDto updateDiplome = diplomeService.updateDiplome(diplome,candidatDto,fichierDto);
        return new ResponseEntity<>(updateDiplome, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDiplome(@PathVariable("id") Integer id) {
        diplomeService.deleteDiplome(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
