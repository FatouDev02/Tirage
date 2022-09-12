package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.PostulantRepository;
import com.example.ApiTirage.Repository.TirageRepository;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<Postulants> faireTirage(@RequestBody Tirage tirage, List<Postulants> listesended, int nbre) {
        //la méthode pour faire des nombres aléatoire "Random"
        Random random = new Random();

        // liste pour récupérer les postulants triés(recois le trie)
        List<Postulants> postulants_tries = new ArrayList<>();
        for (int i = 0; i < nbre; i++) {

            //un id qui va recevoir les index choisit par random
            Integer id_choose = random.nextInt(listesended.size());
            //cette liste va recevoir les id_choisit par random(ajout des index)
            postulants_tries.add(listesended.get(id_choose));
            //on supprime la valeur deja choisit dans la liste envoyée
            listesended.remove(listesended.get(id_choose));
        }
        //table associative
        Tirage t=tirageRepository.save(tirage);

        for( Postulants p:postulants_tries){
            p.getTirages().add(t);

            postulantRepository.save(p);
        }

        tirageRepository.save(tirage);


        return postulants_tries;
    }


}
