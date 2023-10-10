package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.RoleDto;
import com.example.candidaturebachend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@AllArgsConstructor
public class RoleMapper {
    private DozerBeanMapper mapper;

    //Role to Dto
    public RoleDto RoleToRoleDto(Role role) {
        if (role == null) {
            return null;
        }

        RoleDto roleDto = mapper.map(role, RoleDto.class);
        return roleDto;
    }
    //RoleDto to Role
    public Role RoleDtoToRole(RoleDto roleDto){
        if(roleDto == null) {
            return null;
        }
        Role role = mapper.map(roleDto, Role.class);
        return role;
    }
}

