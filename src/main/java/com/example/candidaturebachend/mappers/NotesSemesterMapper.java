package com.example.candidaturebachend.mappers;

import com.example.candidaturebachend.dto.NotesSemesterDto;
import com.example.candidaturebachend.dto.RoleDto;
import com.example.candidaturebachend.entities.NotesSemester;
import com.example.candidaturebachend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class NotesSemesterMapper {
    DiplomeMapper diplomeMapper;
    public NotesSemesterDto NotesSemesterToNotesSemesterDto(NotesSemester notesSemester){
        NotesSemesterDto notesSemesterDto = new NotesSemesterDto();
        BeanUtils.copyProperties(notesSemester, notesSemesterDto);
        notesSemesterDto.setDiplomeDto(diplomeMapper.DiplomeToDiplomeDto(notesSemester.getDiplome()));
        return notesSemesterDto;
    }

    public NotesSemester NotesSemesterDtoToNotesSemester(NotesSemesterDto notesSemesterDto){
        NotesSemester notesSemester = new NotesSemester();
        BeanUtils.copyProperties(notesSemesterDto, notesSemester);
     //   notesSemester.setDiplome(diplomeMapper.DiplomeDtoToDiplome(notesSemesterDto.getDiplomeDto()));
        return notesSemester;
    }
}
