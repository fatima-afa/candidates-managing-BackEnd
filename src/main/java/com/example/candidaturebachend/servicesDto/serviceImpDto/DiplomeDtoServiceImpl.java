package com.example.candidaturebachend.servicesDto.serviceImpDto;

import com.example.candidaturebachend.Exceptions.DiplomeNotFoundException;
import com.example.candidaturebachend.dto.*;
import com.example.candidaturebachend.entities.Diplome;
import com.example.candidaturebachend.entities.NotesSemester;
import com.example.candidaturebachend.mappers.CandidatMapper;
import com.example.candidaturebachend.mappers.DiplomeMapper;
import com.example.candidaturebachend.mappers.FichierMapper;
import com.example.candidaturebachend.mappers.NotesSemesterMapper;
import com.example.candidaturebachend.repositories.DiplomeRepository;
import com.example.candidaturebachend.repositories.NotesSemesterRepository;
import com.example.candidaturebachend.servicesDto.serviceInterfaceDto.IDiplomeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class DiplomeDtoServiceImpl implements IDiplomeDto {
    private DiplomeRepository diplomeRepository;
    private CandidatMapper candidatMapper;
    private DiplomeMapper diplomeMapper;
    private FichierMapper fichierMapper;
    private NotesSemesterMapper notesSemesterMapper;
    private NotesSemesterRepository notesSemesterRepository;
    @Override
    public DiplomeDto saveDiplome(DiplomeDto diplomeDto, CandidatDto candidatDto, FichierDto fichierDto) {
        Diplome diplome=diplomeMapper.DiplomeDtoToDiplome(diplomeDto);
       diplome.setCandidat(candidatMapper.CandidatDtoToCandidat(candidatDto));
        diplome.setFichier(fichierMapper.fichierDtoTofichier(fichierDto));
        Diplome savedDiplome=diplomeRepository.save(diplome);
        log.info("------------------------------------------------------------------------------------------------");
        log.info("id diplome = "+savedDiplome.getId());
        return diplomeMapper.DiplomeToDiplomeDto(savedDiplome);
    }

    public DiplomeDto saveDiplome(DiplomeDto diplomeDto) {

        Diplome diplome=diplomeMapper.DiplomeDtoToDiplome(diplomeDto);
        Diplome savedDiplome=diplomeRepository.save(diplome);
        log.info("------------------------------------------------------------------------------------------------");
        log.info("id diplome = "+savedDiplome);
        DiplomeDto diplomeDtoSaved = diplomeMapper.DiplomeToDiplomeDto(savedDiplome);
        return diplomeDtoSaved ;
    }

    @Override
    public List<DiplomeDto> listDiplomes() {
        List<Diplome> diplomes=diplomeRepository.findAll();
        List<DiplomeDto> diplomeDtos=diplomes.stream()
                .map(diplome -> diplomeMapper.DiplomeToDiplomeDto(diplome))
                .collect(Collectors.toList());
        return diplomeDtos;
    }


    @Override
    public DiplomeDto getDiplome(int id) {
        Diplome diplome=diplomeRepository.findById(id).orElse(null);
        if (diplome==null)throw new DiplomeNotFoundException("diplome not found");
        return diplomeMapper.DiplomeToDiplomeDto(diplome);
    }

    public DiplomeDto getDiplomeByCandidat(CandidatDto candidatDto) {
        Diplome diplome=diplomeRepository.findDiplomeByCandidat(candidatMapper.CandidatDtoToCandidat(candidatDto));
        return diplomeMapper.DiplomeToDiplomeDto(diplome);
    }

    @Override
    public DiplomeDto updateDiplome(DiplomeDto diplomeDto, CandidatDto candidatDto, FichierDto fichierDto) {
        Diplome diplome=diplomeMapper.DiplomeDtoToDiplome(diplomeDto);
        diplome.setCandidat(candidatMapper.CandidatDtoToCandidat(candidatDto));
        diplome.setFichier(fichierMapper.fichierDtoTofichier(fichierDto));
        Diplome savedDiplome=diplomeRepository.save(diplome);
        return diplomeMapper.DiplomeToDiplomeDto(savedDiplome);
    }

    @Override
    public void deleteDiplome(int id) {
        diplomeRepository.deleteById(id);
    }

    @Override
    public List<DiplomeDto> listCandidatureByCin(String cin){
        List<Diplome> diplomes=diplomeRepository.findAllByCandidat_Cin(cin);
        List<DiplomeDto> diplomeDtos=diplomes.stream()
                .map(diplome -> diplomeMapper.DiplomeToDiplomeDto(diplome))
                .collect(Collectors.toList());
        return diplomeDtos;    }

    public NotesSemesterDto saveNoteSemester(NotesSemesterDto notesSemesterDto, DiplomeDto diplomeDto ){
        NotesSemester notesSemester=notesSemesterMapper.NotesSemesterDtoToNotesSemester(notesSemesterDto);
        notesSemester.setDiplome(diplomeMapper.DiplomeDtoToDiplome(diplomeDto));


        //Diplome diplome = diplomeRepository.findById(id).get();
        //notesSemester.setDiplome(diplome);

        NotesSemester saveNotes=notesSemesterRepository.save(notesSemester);
        return notesSemesterMapper.NotesSemesterToNotesSemesterDto(saveNotes);
    }
    public NotesSemesterDto updateNoteSemester(NotesSemesterDto notesSemesterDto,DiplomeDto diplomeDto){
        NotesSemester notesSemester=notesSemesterMapper.NotesSemesterDtoToNotesSemester(notesSemesterDto);
        notesSemester.setDiplome(diplomeMapper.DiplomeDtoToDiplome(diplomeDto));
        NotesSemester saveNotes=notesSemesterRepository.save(notesSemester);
        return notesSemesterMapper.NotesSemesterToNotesSemesterDto(saveNotes);
    }

    public List<NotesSemesterDto> listNotes(){
        List<NotesSemester> notes=notesSemesterRepository.findAll();
        List<NotesSemesterDto> notesSemesterDtos=notes.stream()
                .map(note -> notesSemesterMapper.NotesSemesterToNotesSemesterDto(note))
                .collect(Collectors.toList());
        return notesSemesterDtos;
    }

    public void deleteNotes(int id) {
        notesSemesterRepository.deleteById(id);
    }
}
