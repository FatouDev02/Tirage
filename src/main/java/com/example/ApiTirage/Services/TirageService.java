package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.TirageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TirageService {
    Tirage creer(Tirage tirage);
    String supprimer(Long id_tirage);
    List<Tirage> liste();
    List<Postulants> faireTirage( Tirage tirage, List<Postulants> listesended, int nbre);

}
