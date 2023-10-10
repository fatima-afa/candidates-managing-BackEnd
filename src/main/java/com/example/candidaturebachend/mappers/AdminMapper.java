package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.AdminDto;
import com.example.candidaturebachend.dto.ChefDepartementDto;
import com.example.candidaturebachend.dto.DirectionPedagogiqueDto;
import com.example.candidaturebachend.entities.Admin;
import com.example.candidaturebachend.entities.ChefDepartement;
import com.example.candidaturebachend.entities.DirectionPedagogique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
public class AdminMapper {
    private DozerBeanMapper mapper;
    private DirectionPedagMapper directionPedagMapper;
    private ChefDepartementMapper chefDepartementMapper;

    //admin to dto
    public AdminDto adminToDto(Admin admin){
        if (admin == null) {
            return null;
        }
        AdminDto adminDto = mapper.map(admin, AdminDto.class);
        if(admin.getDirectionPedagogique()!=null){
              DirectionPedagogiqueDto directionPedagogiqueDto = directionPedagMapper.directionPedagogiqueToDto(admin.getDirectionPedagogique());
              adminDto.setDirectionPedagogiqueDto(directionPedagogiqueDto);
              adminDto.setDirectionPedagogiqueDto(mapper.map(admin.getDirectionPedagogique(), DirectionPedagogiqueDto.class));
        }


        if(admin.getChefDepartements()!=null){
            List<ChefDepartementDto> chefDepartementDtos = chefDepartementMapper.ChefDepartementToDtos(admin.getChefDepartements());
            adminDto.setChefDepartementsDto(chefDepartementDtos);
        }
        return adminDto;
    }


    //dto to admin
    public Admin adminDtoToAdmin(AdminDto adminDto){
        if (adminDto == null) {
            return null;
        }
        Admin admin = mapper.map(adminDto, Admin.class);


        if(adminDto.getDirectionPedagogiqueDto()!=null){
            DirectionPedagogique directionPedagogique = directionPedagMapper.dtoTodirectionPedagogique(adminDto.getDirectionPedagogiqueDto());
            admin.setDirectionPedagogique(directionPedagogique);

            //admin.setDirectionPedagogique(mapper.map(adminDto.getDirectionPedagogiqueDto(), DirectionPedagogique.class));
        }


        if(adminDto.getChefDepartementsDto()!=null){
            List<ChefDepartement> chefDepartements = chefDepartementMapper.DtosToChefDepartement(adminDto.getChefDepartementsDto());
            admin.setChefDepartements(chefDepartements);
        }
        return admin;
    }

}

