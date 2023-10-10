package com.example.candidaturebachend.servicesDto.serviceImpDto;

import com.example.candidaturebachend.Exceptions.fileNotFoundException;
import com.example.candidaturebachend.dto.FichierDto;
import com.example.candidaturebachend.entities.Fichier;
import com.example.candidaturebachend.mappers.FichierMapper;
import com.example.candidaturebachend.repositories.FichierRepository;
import com.example.candidaturebachend.servicesDto.serviceInterfaceDto.IFichier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class FichierDtoServiceImpl implements IFichier {
    private FichierMapper fichierMapper;
    private FichierRepository fichierRepository;
    private final String FOLDER_PATH="C:\\mydata\\";


    @Override
    public FichierDto saveFichier(FichierDto fichierDto) {
        log.info("Saving new File");
        Fichier fichier = fichierMapper.fichierDtoTofichier(fichierDto);
        fichier.setId(UUID.randomUUID().toString());
        Fichier savedFichier = fichierRepository.save(fichier);
        log.info("------------------------------------------------------------------------------------------------");
        log.info("id fichier = "+savedFichier.getId());
        return fichierMapper.fichierToFichierDto(savedFichier);
    }

    @Override
    public List<FichierDto> listFichier() {
        List<Fichier> fichiers = fichierRepository.findAll();
        List<FichierDto> fichierDTOS = fichiers.stream()
                .map(fichier -> fichierMapper.fichierToFichierDto(fichier))
                .collect(Collectors.toList());
        return fichierDTOS;
    }

    @Override
    public FichierDto getFichier(String id) throws fileNotFoundException {
        Fichier fichier = fichierRepository.findById(id)
                .orElseThrow(() -> new fileNotFoundException("File Not Found"));
        return fichierMapper.fichierToFichierDto(fichier);
    }

    @Override
    public FichierDto updateFichier(FichierDto fichierDto) {
        log.info("Saving new file");
        Fichier fichier=fichierMapper.fichierDtoTofichier(fichierDto);
        Fichier savedFichier = fichierRepository.save(fichier);
        return fichierMapper.fichierToFichierDto(savedFichier);
    }

    @Override
    public void deleteFichier(String id) {
        fichierRepository.deleteById(id);
    }

    /*public String uploadFile(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        Fichier fichier=fichierRepository.save(Fichier.builder()
                .id(UUID.randomUUID().toString())
                .chemin(filePath).build());

        file.transferTo(new File(filePath));

        if (fichier != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }*/
    public ResponseEntity<FichierDto> uploadFile(MultipartFile file) {
        System.out.println(file);
        try {
            String filePath = FOLDER_PATH + file.getOriginalFilename();
            System.out.println(filePath);
            Fichier fichier = fichierRepository.save(Fichier.builder()
                    .id(UUID.randomUUID().toString())
                    .chemin(filePath).build());
            FichierDto fichierDto=fichierMapper.fichierToFichierDto(fichier);

            file.transferTo(new File(filePath));

            if (fichier != null) {
                //String message = fichier.getId();
                System.out.println(fichier);
                return ResponseEntity.ok(fichierDto);
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


    }
}
