package com.example.candidaturebachend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    private int id;
    private String intitule;
    // private ChefDepartementDto chefDepartementDto;
    //private List<FiliereDto> filieresDto;
}
