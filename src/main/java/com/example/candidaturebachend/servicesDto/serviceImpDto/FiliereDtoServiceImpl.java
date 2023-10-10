package com.example.candidaturebachend.servicesDto.serviceImpDto;

import com.example.candidaturebachend.Exceptions.FiliereNotFoundException;
import com.example.candidaturebachend.dto.DepartementDto;
import com.example.candidaturebachend.dto.FiliereDto;
import com.example.candidaturebachend.entities.Filiere;
import com.example.candidaturebachend.enums.TypeFormation;
import com.example.candidaturebachend.mappers.DepartementMapper;
import com.example.candidaturebachend.mappers.FiliereMapper;
import com.example.candidaturebachend.repositories.CandidatRepository;
import com.example.candidaturebachend.repositories.DepartementRepository;
import com.example.candidaturebachend.repositories.FiliereRepository;
import com.example.candidaturebachend.servicesDto.serviceInterfaceDto.IFiliere;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class FiliereDtoServiceImpl implements IFiliere {
    private FiliereRepository filiereRepository;
    private FiliereMapper filiereMapper;

   // private DepartementRepository departementRepository;
    private DepartementMapper departementMapper;
  //  private CandidatRepository candidatRepository;

    @Override
    public FiliereDto savefiliere(FiliereDto filiereDto, DepartementDto departementDto) {
        Filiere filiere = filiereMapper.FiliereDtoToFiliere(filiereDto);
        filiere.setDepartement(departementMapper.DepartementDtoToDepartement(departementDto));
        //filiere.setDiplome();
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.FiliereToFiliereDto(savedFiliere);
    }

    public FiliereDto savefiliere(FiliereDto filiereDto) {
        Filiere filiere = filiereMapper.FiliereDtoToFiliere(filiereDto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        log.info("id filier : "+savedFiliere);
        return filiereMapper.FiliereToFiliereDto(savedFiliere);
    }

    @Override
    public List<FiliereDto> listFilieres() {
        List<Filiere> filieress = filiereRepository.findAll();
        List<FiliereDto> filiereDtos = filieress.stream()
                .map(filiere -> filiereMapper.FiliereToFiliereDto(filiere))
                .collect(Collectors.toList());
        return filiereDtos;
    }

 /*   @Override
    public List<FiliereDto> searchFiliere1(String keyword) {
        List<Filiere> filieres= filiereRepository.searchFiliere(keyword);
                return filieres.stream()
                        .map(filiereMapper::FiliereToFiliereDto)
                        .collect(Collectors.toList());
    }
*/
    @Override
    public List<FiliereDto> searchFiliere(String keyword) {
        List<Filiere> filieres= filiereRepository.searchAllByIntituleContains(keyword);
        return filieres.stream()
                .map(filiereMapper::FiliereToFiliereDto)
                .collect(Collectors.toList());    }

    @Override
    public FiliereDto getFiliereById(int filiereId) throws FiliereNotFoundException {
        Filiere filiere = filiereRepository.findById(filiereId)
                .orElseThrow(() -> new FiliereNotFoundException("Filiere not found"));
        return filiereMapper.FiliereToFiliereDto(filiere);
    }

    @Override
    public List<FiliereDto> getFilieresForCandidat(int candidatId) {
        List<Filiere> filieres = filiereRepository.findByCandidatsId(candidatId);
        List<FiliereDto> filiereDtos = filieres.stream()
                .map(filiere -> filiereMapper.FiliereToFiliereDto(filiere))
                .collect(Collectors.toList());
        return filiereDtos;
    }
    @Override
    public List<FiliereDto> getFiliereByFormation(TypeFormation typeFormation){
        List<Filiere> filieres = filiereRepository.findFiliereByTypeFormation(typeFormation);
        List<FiliereDto> filiereDtos = filieres.stream()
                .map(filiere -> filiereMapper.FiliereToFiliereDto(filiere))
                .collect(Collectors.toList());
        return filiereDtos;
    }

    @Override
    public List<FiliereDto> getFiliereByDepartement(DepartementDto departementDto) {
        List<Filiere> filieres = filiereRepository.findFiliereByDepartement(departementMapper.DepartementDtoToDepartement(departementDto));
        List<FiliereDto> filiereDtos = filieres.stream()
                .map(filiere -> filiereMapper.FiliereToFiliereDto(filiere))
                .collect(Collectors.toList());
        return filiereDtos;
    }


    @Override
    public void deletFiliere(int filiereId) {
        filiereRepository.deleteById(filiereId);
    }
}
