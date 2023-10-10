package com.example.candidaturebachend.servicesDto.serviceInterfaceDto;

import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.DiplomeDto;
import com.example.candidaturebachend.dto.FichierDto;

import java.util.List;

public interface IDiplomeDto {
    DiplomeDto saveDiplome(DiplomeDto diplomeDto,CandidatDto candidatDto, FichierDto fichierDto);
    List<DiplomeDto> listDiplomes();
    DiplomeDto getDiplome(int id);
    DiplomeDto updateDiplome(DiplomeDto diplomeDto, CandidatDto candidatDto, FichierDto fichierDto);
    void deleteDiplome(int id);

    List<DiplomeDto> listCandidatureByCin(String cin);
}
