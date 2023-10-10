package com.example.candidaturebachend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class NotesSemester implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Double note;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Diplome diplome;
}
