package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.*;
import com.example.candidaturebachend.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

@Service
@AllArgsConstructor
public class DiplomeMapper {

    private FichierMapper fichierMapper;
    private FiliereMapper filiereMapper;
    private CandidatMapper candidatMapper;

    //Diplome entity to Dto
    public DiplomeDto DiplomeToDiplomeDto(Diplome diplomeDto) {
        DiplomeDto diplome=new DiplomeDto();
        //BeanUtils.copyProperties(diplome,diplomeDto);
        diplome.setSpecialiteDiplome(diplomeDto.getSpecialiteDiplome());
        diplome.setUniversite(diplomeDto.getUniversite());
        diplome.setAnneeObtention(diplomeDto.getAnneeObtention());
        diplome.setEtablissement(diplomeDto.getEtablissement());
        diplome.setId(diplomeDto.getId());
        diplome.setTypeDiplome(diplomeDto.getTypeDiplome());

        diplome.setFichierDto(fichierMapper.fichierToFichierDto(diplomeDto.getFichier()));
        diplome.setCandidatDto(candidatMapper.candidatToDto(diplomeDto.getCandidat()));
        diplome.setFiliereDto(filiereMapper.FiliereToFiliereDto(diplomeDto.getFiliere()));
        return diplome;
    }

    public Diplome DiplomeDtoToDiplome(DiplomeDto diplomeDto) {
        Diplome diplome=new Diplome();
     //   BeanUtils.copyProperties(diplomeDto,diplome);

        diplome.setSpecialiteDiplome(diplomeDto.getSpecialiteDiplome());
        diplome.setUniversite(diplomeDto.getUniversite());
        diplome.setAnneeObtention(diplomeDto.getAnneeObtention());
        diplome.setEtablissement(diplomeDto.getEtablissement());
        diplome.setId(diplomeDto.getId());
        diplome.setTypeDiplome(diplomeDto.getTypeDiplome());
        diplome.setFichier(fichierMapper.fichierDtoTofichier(diplomeDto.getFichierDto()));
        diplome.setCandidat(candidatMapper.CandidatDtoToCandidat(diplomeDto.getCandidatDto()));
        diplome.setFiliere(filiereMapper.FiliereDtoToFiliere(diplomeDto.getFiliereDto()));
        return diplome;
    }



    //Lists
    /*public List<DiplomeDto> AllDiplomesToDto(List<Diplome> diplomes) {

        if (CollectionUtils.isEmpty(diplomes)) {
            return Collections.emptyList();
        }

        List<DiplomeDto> diplomeDtos = new ArrayList<>();

        for (Diplome diplome : diplomes) {
            diplomeDtos.add(DiplomeToDiplomeDto(diplome));
        }
        return diplomeDtos;


  //return diplomes.stream().map(x ->DiplomeToDiplomeDto(x)).collect(Collectors.toList());



    }*/
    //DTO to diplome


    //Lists
   /* public List<Diplome> AllDtoToDiplomes(List<DiplomeDto> diplomesDto) {

        if (CollectionUtils.isEmpty(diplomesDto)) {
            return Collections.emptyList();
        }
        List<Diplome> diplomes = new ArrayList<>();

        for (DiplomeDto diplomedto : diplomesDto) {
            diplomes.add(DiplomeDtoToDiplome(diplomedto));
        }
        return diplomes;


 //return diplomesDto.stream().map(x ->DiplomeDtoToDiplome(x)).collect(Collectors.toList());



    }*/
}

