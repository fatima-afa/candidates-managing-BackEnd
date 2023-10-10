package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.*;
import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.ChefDepartement;
import com.example.candidaturebachend.entities.Departement;
import com.example.candidaturebachend.entities.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@AllArgsConstructor


public class DepartementMapper {

    //departement to dto
    public DepartementDto DepartementToDepartementDto(Departement departement){
        DepartementDto departementDto=new DepartementDto();
        BeanUtils.copyProperties(departement,departementDto);
        return departementDto;
    }


    //departementDto to departement
    public Departement DepartementDtoToDepartement(DepartementDto departementDto){
        Departement departement = new Departement();
        BeanUtils.copyProperties(departementDto,departement);
        return departement;
    }



}
