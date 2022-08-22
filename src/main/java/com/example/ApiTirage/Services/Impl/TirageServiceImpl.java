package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.PostulantsTries;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.ListeRepository;
import com.example.ApiTirage.Repository.PostulantRepository;
import com.example.ApiTirage.Repository.PostulantsTriesRepository;
import com.example.ApiTirage.Repository.TirageRepository;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Data
@Service
public class TirageServiceImpl implements TirageService {
    @Autowired
    ListeRepository listeRepository;
    @Autowired
    TirageRepository tirageRepository;
    @Autowired
    PostulantRepository postulantRepository;
    @Autowired
    PostulantsTriesRepository postulantsTriesRepository;
    @Override
    public Tirage creer(Tirage tirage) {

        return tirageRepository.save(tirage);
    }

    @Override
    public String supprimer(Long id_tirage) {
        tirageRepository.deleteById(id_tirage);
        return "Le tirage a été supprimé avec succès !";
    }

    @Override
    public List<Tirage> liste() {

        return tirageRepository.findAll();
    }

    @Override
    public List<Postulants> faireTirage(List<Postulants> postulants, Long nombre_personnes) {
        ListImport liste = new ListImport();
        Postulants postulant = new Postulants();
        // liste qui va récupérer les nombres aléatoire
        List<Integer> listes_numero = new ArrayList<>();
        // liste pour récupérer le postulants trié
        Collections.shuffle(postulants);
        List<Postulants> postulants_tries = new ArrayList<>();
        List<Postulants> postrecp = postulantRepository.findByListImport(liste.getId_list());
        for (int i = 1; i <= nombre_personnes; i++) {
            PostulantsTries pst = new PostulantsTries();
            Postulants po = postrecp.get(i);
            pst.setPrenom(po.getPrenom());
            pst.setNom(po.getPrenom());
            pst.setNumero(po.getNumero());
            pst.setEmail(po.getEmail());

            postulantsTriesRepository.save(pst);

        }
        Tirage tirage = new Tirage();
        tirage.setDate_tirage(new Date());
        tirage.setLibelle_tirage("Resultat du " + liste.getLibelle());
        return postulants_tries;
    }
}
