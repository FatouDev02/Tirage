package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Repository.PostulantRepository;
import com.example.ApiTirage.Services.PostulantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulantServiceImpl implements PostulantServices {
    @Autowired
    PostulantRepository postulantRepository;

    @Override
    public Postulants Ajout(Postulants postulants) {

        return this.postulantRepository.save(postulants);
    }

    @Override
    public List<Postulants> liste() {
        return this.postulantRepository.findAll();
    }

    @Override
    public Postulants Modifier(Postulants postulants, Integer Id_postulant) {

        return postulantRepository.findById(Id_postulant)
                .map(postulants1 -> {
                    postulants1.setNom(postulants.getNom());
                    postulants1.setPrenom(postulants.getPrenom());
                    postulants1.setEmail(postulants.getEmail());
                    postulants1.setNumero(postulants.getNumero());
                    return postulantRepository.save(postulants1);
                }).orElseThrow(() -> new RuntimeException("Cet postulant n'existe pas"));


    }

    @Override
    public String SupprimerbyId(Integer Id_postulant) {
         this.postulantRepository.deleteById(Id_postulant);
         return "Supprimé avec succes";
    }



}
