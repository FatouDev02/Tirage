package com.example.ApiTirage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int nombre_tirage=0;

    @JsonIgnore
    @OneToMany(mappedBy = "listImport")
    List<Postulants> liste_postulant;


}
