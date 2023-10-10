package com.example.candidaturebachend.servicesDto.serviceImpDto;

import com.example.candidaturebachend.Exceptions.DepartementNotFoundException;
import com.example.candidaturebachend.dto.CandidatDto;
import com.example.candidaturebachend.dto.DepartementDto;
import com.example.candidaturebachend.entities.Candidat;
import com.example.candidaturebachend.entities.Departement;
import com.example.candidaturebachend.mappers.DepartementMapper;
import com.example.candidaturebachend.repositories.DepartementRepository;
import com.example.candidaturebachend.servicesDto.serviceInterfaceDto.IDepartement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DepartementDtoServiceImpl implements IDepartement {
    private DepartementRepository departementRepository;
    private DepartementMapper departementMapper;

    public  List<DepartementDto> searchDepartements(String cle) {
        List<Departement>departements = departementRepository.searchDepartements(cle);
        return departements.stream()
                .map(departementMapper::DepartementToDepartementDto)
                .collect(Collectors.toList());
    }


    @Override
    public DepartementDto savedepartement(DepartementDto departementDto) {
        Departement departement = departementMapper.DepartementDtoToDepartement(departementDto);
        Departement savedDepartement = departementRepository.save(departement);
        return departementMapper.DepartementToDepartementDto(savedDepartement);
    }

    @Override
    public List<DepartementDto> listDepartements() {
        List<Departement> departements=departementRepository.findAll();
        List<DepartementDto> departementDtos=departements.stream()
                .map(departement -> departementMapper.DepartementToDepartementDto(departement))
                .collect(Collectors.toList());
        return departementDtos;
    }

    @Override
    public DepartementDto getDepartement(int departementID) throws DepartementNotFoundException {
        Departement departement = departementRepository.findById(departementID)
                .orElseThrow(()->new DepartementNotFoundException("departement not found"));
        return departementMapper.DepartementToDepartementDto(departement);
    }

    @Override
    public DepartementDto updateDepartement(DepartementDto departementDto) {
        log.info("Saving new Departement");
        Departement departement=departementMapper.DepartementDtoToDepartement(departementDto);
        Departement savedDepartement = departementRepository.save(departement);
        return departementMapper.DepartementToDepartementDto(savedDepartement);
    }

    @Override
    public void deletDepartement(int departementId) {
        departementRepository.deleteById(departementId);
    }
}
