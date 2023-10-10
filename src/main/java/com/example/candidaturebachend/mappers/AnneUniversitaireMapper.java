package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.AnneUniversitaireDto;
import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.FiliereDto;
import com.example.candidaturebachend.entities.AnneUniversitaire;
import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Component
//@Data
//@AllArgsConstructor
/*public class AnneUniversitaireMapper {

    private DozerBeanMapper mapper;
    private CandidatMapper candidatMapper;

    //anneUniv to dto
    public AnneUniversitaireDto anneUniversitaireToanneUniversitaireDto(AnneUniversitaire anneUniversitaire){
        if(anneUniversitaire==null)
            return null;
        AnneUniversitaireDto anneUniversitaireDto=mapper.map(anneUniversitaire, AnneUniversitaireDto.class);
        /*if (anneUniversitaire.getCandidats() != null) {
            List<CandidatDto> candidatDtos = candidatMapper.AllCandidatsToDto(anneUniversitaire.getCandidats());
            anneUniversitaireDto.setCandidatsDto(candidatDtos);
            // diplomeDto.setFilieresDto(mapper.map(diplomeDto.g(), ZoneDto.class));
        }*/
        /*return anneUniversitaireDto;
    }
    public List<AnneUniversitaireDto> AllAnneUniversitaireToDto(List<AnneUniversitaire> anneUniversitaires){

        if (CollectionUtils.isEmpty(anneUniversitaires)) {
            return Collections.emptyList();
        }
        List<AnneUniversitaireDto> anneUniversitaireDtos=new ArrayList<>();
        for (AnneUniversitaire anneUniversitaire : anneUniversitaires) {
            anneUniversitaireDtos.add(anneUniversitaireToanneUniversitaireDto(anneUniversitaire));
        }
        return anneUniversitaireDtos;

    }

    //dto to anneUniv
    public AnneUniversitaire anneUniversitaireDtoToanneUniversitaire(AnneUniversitaireDto anneUniversitaireDto){
        if(anneUniversitaireDto==null)
            return null;
        AnneUniversitaire anneUniversitaire=mapper.map(anneUniversitaireDto, AnneUniversitaire.class);
        /*if (anneUniversitaireDto.getCandidatsDto() != null) {
            List<Candidat> candidats = candidatMapper.AllDtoToCandidats(anneUniversitaireDto.getCandidatsDto());
            anneUniversitaire.setCandidats(candidats);
        }*/
        /*return anneUniversitaire;
    }

    public List<AnneUniversitaire> DtosToAnneUniversitaire(List<AnneUniversitaireDto> anneUniversitaireDtos){
        if (CollectionUtils.isEmpty(anneUniversitaireDtos)) {
            return Collections.emptyList();
        }
        List<AnneUniversitaire> anneUniversitaires=new ArrayList<>();
        for (AnneUniversitaireDto anneUniversitaireDto : anneUniversitaireDtos) {
            anneUniversitaires.add(anneUniversitaireDtoToanneUniversitaire(anneUniversitaireDto));
        }
        return anneUniversitaires;
    }

}*/

