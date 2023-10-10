package com.example.candidaturebachend.entities;

import com.example.candidaturebachend.enums.TypeDiplomeAObtenir;
import com.example.candidaturebachend.enums.TypeFormation;
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
public class Filiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String intitule;
    @Enumerated(EnumType.STRING)
    private TypeFormation typeFormation;
    @Enumerated(EnumType.STRING)
    private TypeDiplomeAObtenir typeDiplomeAObtenir;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Departement departement;
    @ManyToMany(mappedBy = "filieres",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Candidat> candidats;
    @OneToOne(mappedBy = "filiere")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Diplome diplome;

}
