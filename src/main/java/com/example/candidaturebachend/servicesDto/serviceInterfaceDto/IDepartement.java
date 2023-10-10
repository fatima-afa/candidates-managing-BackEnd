package com.example.candidaturebachend.servicesDto.serviceInterfaceDto;

import com.example.candidaturebachend.Exceptions.DepartementNotFoundException;
import com.example.candidaturebachend.dto.DepartementDto;

import java.util.List;

public interface IDepartement {

    DepartementDto savedepartement(DepartementDto departementDto);

    List<DepartementDto> listDepartements();

    DepartementDto getDepartement(int departementID) throws DepartementNotFoundException;

    DepartementDto updateDepartement(DepartementDto departementDto);

    void deletDepartement( int departementId);
}
