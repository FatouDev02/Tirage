package com.example.ApiTirage.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Postulants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_postulant;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero;

    @ManyToOne
    private ListImport listImport;
}
