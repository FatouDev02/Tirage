package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.PostulantsTries;

import java.util.List;

public interface PostulantsTriesService {
    PostulantsTries Ajout(PostulantsTries postulants);
    List<PostulantsTries> liste();
    PostulantsTries Modifier(PostulantsTries pays,Long Id_postulant);
    String SupprimerbyId(Long Id_postulantsTries);
}
