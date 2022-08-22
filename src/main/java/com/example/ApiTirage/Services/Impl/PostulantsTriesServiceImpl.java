package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.PostulantsTries;
import com.example.ApiTirage.Repository.PostulantsTriesRepository;
import com.example.ApiTirage.Services.PostulantsTriesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class PostulantsTriesServiceImpl implements PostulantsTriesService {
    @Autowired
    PostulantsTriesRepository psr;
    @Override
    public PostulantsTries Ajout(PostulantsTries pst_Trie) {
        return psr.save(pst_Trie);
    }

    @Override
    public List<PostulantsTries> liste() {
        return psr.findAll();
    }

    @Override
    public PostulantsTries Modifier(PostulantsTries postulantsTries, Long Id_postulant) {
        return psr.findById(Id_postulant)
                .map(p -> {
                    p.setNom(postulantsTries.getNom());
                    p.setPrenom(postulantsTries.getPrenom());
                    p.setEmail(postulantsTries.getEmail());
                    p.setNumero(postulantsTries.getNumero());
                    return psr.save(p);
                }).orElseThrow(() -> new RuntimeException("Cet postulant trié n'existe pas"));
    }

    @Override
    public String SupprimerbyId(Long Id_postulantsTries) {
        psr.deleteById(Id_postulantsTries);
        return "Postulant Trié supprimer avec succés !";
    }
}
