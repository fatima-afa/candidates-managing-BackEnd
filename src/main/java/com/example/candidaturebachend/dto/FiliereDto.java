package com.example.candidaturebachend.dto;

import com.example.candidaturebachend.enums.TypeDiplomeAObtenir;
import com.example.candidaturebachend.enums.TypeFormation;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {

    private int id;
    private String intitule;
    private TypeFormation typeFormation;
    private TypeDiplomeAObtenir typeDiplomeAObtenir;

    private DepartementDto departementDto;//nrdoha dto
    //private List<CandidatDto> candidatsDto;//hta hadi
    //private DiplomeDto diplomeDto;

}