package com.example.candidaturebachend.mappers;
import com.example.candidaturebachend.dto.*;
import com.example.candidaturebachend.entities.Admin;
import com.example.candidaturebachend.entities.ChefDepartement;
import com.example.candidaturebachend.entities.Departement;
import com.example.candidaturebachend.entities.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Data
@ToString
@AllArgsConstructor
public class ChefDepartementMapper {
    private DozerBeanMapper mapper;
    private DepartementMapper departementMapper;


    //chefdepartement to dto
    public ChefDepartementDto chefDepartemenToChefDepartementDto(ChefDepartement chefDepartement){

        if (chefDepartement == null) {
            return null;
        }

        ChefDepartementDto chefDepartementDto = mapper.map(chefDepartement, ChefDepartementDto.class);
        //departemet object
        if(chefDepartement.getDepartement()!=null){

            DepartementDto departementDto=departementMapper.DepartementToDepartementDto(chefDepartement.getDepartement());
            chefDepartementDto.setDepartementDto(departementDto);
        }
        //admin object


        return chefDepartementDto;
    }
    public List<ChefDepartementDto> ChefDepartementToDtos(List<ChefDepartement> chefDepartements){
        if (CollectionUtils.isEmpty(chefDepartements)) {
            return Collections.emptyList();
        }

        List<ChefDepartementDto> chefDepartementDtos = new ArrayList<>();

        for (ChefDepartement chefDepartement : chefDepartements) {
            chefDepartementDtos.add(chefDepartemenToChefDepartementDto(chefDepartement));
        }
        return chefDepartementDtos;


    }


    //dto to chefDepartement
    public ChefDepartement chefDepartemenDtoToChefDepartement(ChefDepartementDto chefDepartementDto){
        if(chefDepartementDto==null)
            return null;

        ChefDepartement chefDepartement=mapper.map(chefDepartementDto, ChefDepartement.class);

        if(chefDepartementDto.getDepartementDto()!=null){
            Departement departement=departementMapper.DepartementDtoToDepartement(chefDepartementDto.getDepartementDto());
            chefDepartement.setDepartement(departement);

        }


        return chefDepartement;

    }
    public List<ChefDepartement> DtosToChefDepartement(List<ChefDepartementDto> chefDepartementDtos){
        if (CollectionUtils.isEmpty(chefDepartementDtos)) {
            return Collections.emptyList();
        }

        List<ChefDepartement> chefDepartements = new ArrayList<>();

        for (ChefDepartementDto chefDepartementDto : chefDepartementDtos) {
            chefDepartements.add(chefDepartemenDtoToChefDepartement(chefDepartementDto));
        }
        return chefDepartements;

    }

}
