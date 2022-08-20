package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Repository.TirageRepository;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Data
@Component
public class TirageServiceImpl implements TirageService {
    private final TirageRepository tirageRepository;
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
}
