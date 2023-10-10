package com.example.candidaturebachend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnneUniversitaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String anneUniv;
    @ManyToMany
    //@JoinTable(name = "Archieve")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Candidat> candidats;
}