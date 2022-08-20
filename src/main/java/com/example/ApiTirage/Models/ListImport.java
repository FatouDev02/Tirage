package com.example.ApiTirage.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ListImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_list;
    private String libelle;
    private Date dateimport;


    @OneToMany(mappedBy = "listImport")
    List<Postulants> liste_postulant;


    @OneToMany(mappedBy = "listImport")
    List<Postulants> liste_postulant;


}
