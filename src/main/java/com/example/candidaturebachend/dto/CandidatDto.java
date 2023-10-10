package com.example.candidaturebachend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDto{
    private String id;
    protected String cin;
    protected String nom;
    protected String prenom;
    protected String addresse;
    protected String email;
    protected Date dateNaissance;
    protected String telephone;
    protected String mdp;
    private String cne;
    private String ville;
    private boolean admis;
    private String pays;
    private String bac;
    private String paysObtentionBac;
    private Date bacAnneObtention;
    //private List<FiliereDto> filieresDto;
    //private List<DiplomeDto> diplomesDto;

}
