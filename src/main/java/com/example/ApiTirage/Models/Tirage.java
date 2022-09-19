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
    @Column(unique=true )
    private  String libelle_tirage;
    private Date date_tirage;
    private int nbredepostulants;

    @ManyToMany(mappedBy = "tirages")
    List<Postulants> postulant1;




}
