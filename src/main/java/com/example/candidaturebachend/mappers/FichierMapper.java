package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.DiplomeDto;
import com.example.candidaturebachend.dto.FichierDto;
import com.example.candidaturebachend.entities.Diplome;
import com.example.candidaturebachend.entities.Fichier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FichierMapper {

    //fichier to Dto
    public FichierDto fichierToFichierDto(Fichier fichier) {
       FichierDto fichierDto=new FichierDto();
       BeanUtils.copyProperties(fichier,fichierDto);
       return fichierDto;
    }

    public Fichier fichierDtoTofichier(FichierDto fichierDto){
        Fichier fichier=new Fichier();
        BeanUtils.copyProperties(fichierDto,fichier);
       return fichier;
    }
}

