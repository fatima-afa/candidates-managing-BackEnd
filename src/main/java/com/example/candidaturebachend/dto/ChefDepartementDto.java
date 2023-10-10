package com.example.candidaturebachend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChefDepartementDto {
    private String id;
    protected String cin;
    protected String nom;
    protected String prenom;
    protected String addresse;
    protected String email;
    protected Date dateNaissance;
    protected String telephone;
    protected String mdp;
    private String matricule;
    private DepartementDto departementDto;

}
