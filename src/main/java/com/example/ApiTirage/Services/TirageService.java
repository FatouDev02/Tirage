package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.TirageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TirageService {
    Tirage creer(Tirage tirage);
    String supprimer(Long id_tirage);



    List<Tirage> liste();


    List<Postulants> faireTirage(List<Postulants> postulants, int nombre_personnes);
    List<Postulants> creerTirage(Tirage tirage,List<Postulants> postulants, int nombre_personnes);

    Object listerTiragesParLibbelleliste(String libelle_tirage);
    List<Tirage> listerTiragesParIDliste(Long id_list);

}
