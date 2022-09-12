package com.example.ApiTirage.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tirage;
    private  String libelle_tirage;
    private Date date_tirage;
    private int nbredepostulants;
            // private int nombre_personnes;

    @ManyToMany(mappedBy = "tirages")
    List<Postulants> postulant1;



}
