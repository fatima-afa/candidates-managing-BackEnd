package com.example.candidaturebachend.dto;

import com.example.candidaturebachend.enums.TypeDiplome;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomeDto {

    private int id;

    private TypeDiplome typeDiplome;
    private String specialiteDiplome;
    private Date anneeObtention;
    private String etablissement;
    private String universite;
    private CandidatDto candidatDto;
    private FiliereDto filiereDto;
    private FichierDto fichierDto;
    //private List<NotesSemesterDto> notesSemesterDto;

}
