package com.example.candidaturebachend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesSemesterDto {
    int id;
    Double note;
    DiplomeDto diplomeDto;
}
