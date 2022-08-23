package com.example.ApiTirage.Models;

import lombok.Data;

import javax.persistence.*;
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
//relation 1 , n avec la liste
   @ManyToOne
    ListImport listImport;
// relation n,n,avec la classe tirage
    @ManyToMany
//    @JoinTable(
//            name = "PostulantTirage",
//            joinColumns = @JoinColumn(name="Postulant_id"),
//            inverseJoinColumns = @JoinColumn(name = "tirage_id")
//    )
    List<Tirage> tirages;
}
