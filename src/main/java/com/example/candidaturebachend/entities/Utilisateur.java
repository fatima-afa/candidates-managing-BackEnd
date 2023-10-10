package com.example.candidaturebachend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Incubating;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "TYPE",length = 6)
public abstract class Utilisateur implements Serializable {
    @Id
    protected String id;
    protected String cin;
    protected String nom;
    protected String prenom;
    protected String addresse;
    protected String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date dateNaissance;
    protected String telephone;
    protected String mdp;

    @ManyToMany(mappedBy = "utilisateurs", fetch = FetchType.EAGER )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected List<Role> roles;


}
