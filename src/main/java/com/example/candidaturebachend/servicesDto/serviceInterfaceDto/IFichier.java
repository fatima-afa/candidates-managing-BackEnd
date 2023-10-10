package com.example.candidaturebachend.servicesDto.serviceInterfaceDto;

import com.example.candidaturebachend.Exceptions.fileNotFoundException;
import com.example.candidaturebachend.dto.FichierDto;

import java.util.List;

public interface IFichier {

    FichierDto saveFichier(FichierDto fichierDto);
    List<FichierDto> listFichier();
    FichierDto getFichier(String id) throws fileNotFoundException;
    FichierDto updateFichier(FichierDto fichierDto);
    void deleteFichier(String id);
}
