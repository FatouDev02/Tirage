package com.example.ApiTirage.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Postulants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_postulant;
    private String nom;
    private String prenom;
    private String email;
    private String numero;

    @ManyToOne
    private ListImport listImport;

    @ManyToMany
    @JoinTable(
            name = "Postulants_Tirage",
            joinColumns = @JoinColumn(name="Postulants_id"),
            inverseJoinColumns = @JoinColumn(name = "Tirage_id")
    )
    private List<Tirage>  tirage;
}
