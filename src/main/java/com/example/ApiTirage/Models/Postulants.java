package com.example.ApiTirage.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Postulants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_postulant;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero;
}
