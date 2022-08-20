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
    public List<Postulants> faireTirage(List<Postulants> postulants, Long nombre) {

        List<Postulants> postulantsList;
        Random random = new Random();
        List<Integer> listes_numero = new ArrayList<>();
        List<Postulants> postulants_tries = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            int numero;
            numero = random.nextInt(postulants.size());
            while (numero == 0 || listes_numero.contains(numero)) {
                numero = random.nextInt(postulants.size());
            }
            listes_numero.add(numero);

            postulants_tries.add(postulantRepository.findById(numero).orElseThrow());

        }
        return postulants_tries;
    }
}
