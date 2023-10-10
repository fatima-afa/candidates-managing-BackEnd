package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.NotesSemester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesSemesterRepository extends JpaRepository<NotesSemester, Integer> {

 //   Optional<NotesSemester> findNotesSemesterById(Integer id);
}
