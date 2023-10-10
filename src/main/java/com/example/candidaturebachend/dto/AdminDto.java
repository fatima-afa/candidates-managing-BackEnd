package com.example.candidaturebachend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private int id;
    private String username;
    private String mdp;
    private List<ChefDepartementDto> chefDepartementsDto;
    private DirectionPedagogiqueDto directionPedagogiqueDto;
}
