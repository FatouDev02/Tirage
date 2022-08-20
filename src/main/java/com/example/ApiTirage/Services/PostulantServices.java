package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.Postulants;

import java.util.List;

public interface PostulantServices {
    Postulants Ajout(Postulants postulants);
    List<Postulants> liste();
    Postulants Modifier(Postulants pays,Long Id_postulant);
    String SupprimerbyId(Long Id_postulant);

}
