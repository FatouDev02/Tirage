package com.example.ApiTirage.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostulantsTries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post_trie;
    private String nom;
    private String prenom;
    private String email;
    private Long numero;


}
