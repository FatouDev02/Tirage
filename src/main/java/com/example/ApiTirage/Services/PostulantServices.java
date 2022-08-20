package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.Postulants;

import java.util.List;

public interface PostulantServices {
    Postulants Ajout(Postulants postulants);
    List<Postulants> liste();
    Postulants Modifier(Postulants pays,Integer Id_postulant);
    String SupprimerbyId(Integer Id_postulant);

}
