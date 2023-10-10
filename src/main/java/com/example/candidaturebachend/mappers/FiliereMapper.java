package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.DepartementDto;
import com.example.candidaturebachend.dto.DiplomeDto;
import com.example.candidaturebachend.dto.FiliereDto;
import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.Departement;
import com.example.candidaturebachend.entities.Diplome;
import com.example.candidaturebachend.entities.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FiliereMapper {
    private DepartementMapper departementMapper;

    //Filiere to Dto
    public FiliereDto FiliereToFiliereDto(Filiere filiere) {
        FiliereDto filiereDto=new FiliereDto();
        BeanUtils.copyProperties(filiere,filiereDto);
        if(filiere.getDepartement()!=null)
            filiereDto.setDepartementDto(departementMapper.DepartementToDepartementDto(filiere.getDepartement()));
        else
            filiereDto.setDepartementDto(null);
        return filiereDto;
    }

    //Dto to Filiere
    public Filiere FiliereDtoToFiliere(FiliereDto filiereDto) {
        Filiere filiere=new Filiere();
        BeanUtils.copyProperties(filiereDto,filiere);
        if(filiereDto.getDepartementDto()!=null)
            filiere.setDepartement(departementMapper.DepartementDtoToDepartement(filiereDto.getDepartementDto()));
        else
            filiere.setDepartement(null);

        return filiere;
    }

    public List<Filiere> mapFilieresDtoToFilieres(List<FiliereDto> filiereDtos) {
        if (filiereDtos == null) {
            return new ArrayList<>();
        }
        return filiereDtos.stream()
                .map(this::FiliereDtoToFiliere)
                .collect(Collectors.toList());
    }


}

