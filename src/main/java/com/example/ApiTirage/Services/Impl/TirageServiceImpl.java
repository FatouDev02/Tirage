package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.PostulantRepository;
import com.example.ApiTirage.Repository.TirageRepository;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
@Component
public class TirageServiceImpl implements TirageService {
    private final TirageRepository tirageRepository;
    private final PostulantRepository postulantRepository;

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
    public List<Postulants> faireTirage(List<Postulants> postulants, int nombre_personnes) {
        //la méthode pour faire des nombre aléatoire "Random"
        Random random = new Random();
        // liste qui va récupérer les nombres aléatoire
        List<Integer> listes_numero = new ArrayList<>();
        // liste pour récupérer le postulants triés
        List<Postulants> postulants_tries = new ArrayList<>();
        for (int i = 0; i < nombre_personnes; i++) {
            int numero;
            numero = random.nextInt(postulants.size());
            while (numero == 0 || listes_numero.contains(numero)) {
                numero = random.nextInt(postulants.size());
            }
            listes_numero.add(numero);

            postulants_tries.add(postulantRepository.findById((long) numero).orElseThrow());

        }

        return postulants_tries;
    }

    @Override
    public List<Postulants> creerTirage(Tirage tirage, List<Postulants> postulants, int nombre_personnes) {
        Random random = new Random();
        // liste qui va récupérer les nombres aléatoire

        List<Postulants> list = new ArrayList<>();
        for (int i = 0; i < nombre_personnes; i++) {
            int numero;
            numero = random.nextInt(postulants.size());

            list.add(postulants.get(numero));
            postulants.remove(postulants.get(numero));

        }
        Tirage tirage1 = tirageRepository.save(tirage);
        for (Postulants p : list) {
            p.getTirages().add(tirage1);
            postulantRepository.save(p);

        }
        tirageRepository.save(tirage);
        return list;
    }

    @Override
    public Object listerTiragesParLibbelleliste(String libelle_tirage) {
        return null;
    }

    @Override
    public List<Tirage> listerTiragesParIDliste(Long id_list) {
        return tirageRepository.FIND_TIRAGE_BY_LISTE_ID(id_list);
    }
}

