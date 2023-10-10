package com.example.candidaturebachend.servicesDto.serviceInterfaceDto;


import com.example.candidaturebachend.entities.Departement;

import java.util.List;

public interface IDepart {
    Departement savedepartement(Departement departement);

    List<Departement> listDepartements();

    Departement getDepartement(int departementID);

    Departement updateDepartement(Departement departement);

    void deletDepartement( int departementId);
}
