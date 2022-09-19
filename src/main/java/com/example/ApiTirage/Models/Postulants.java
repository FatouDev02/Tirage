package com.example.ApiTirage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Postulants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_postulant;
    private String nom;
    private String prenom;
    private String email;
    private String numero;

    @ManyToOne
    ListImport listImport;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "PostulantTirage",
            joinColumns = @JoinColumn(name="Postulant_id"),
            inverseJoinColumns = @JoinColumn(name = "tirage_id")
    )
    List<Tirage> tirages=new ArrayList<>();
}
