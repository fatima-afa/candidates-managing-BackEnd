package com.example.candidaturebachend.entities;

import com.example.candidaturebachend.enums.TypeDiplome;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diplome implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeDiplome typeDiplome;
    private String specialiteDiplome;
    private Date anneeObtention;
    private String etablissement;
    private String universite;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Candidat candidat;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Filiere filiere;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Fichier fichier;
    @OneToMany(mappedBy = "diplome",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<NotesSemester> notesSemester=new ArrayList<>();
}
