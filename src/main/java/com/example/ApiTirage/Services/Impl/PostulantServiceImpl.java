package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Repository.PostulantRepository;
import com.example.ApiTirage.Services.PostulantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulantServiceImpl implements PostulantServices {
    @Autowired
    PostulantRepository postulantRepository;

    @Override
    public Postulants Ajout(Postulants pays) {
        return this.postulantRepository.save(pays);
    }

    @Override
    public List<Postulants> liste() {
        return this.postulantRepository.findAll();
    }

    @Override
    public Postulants Modifier(Postulants postulants, Integer Id_postulant) {
        Postulants postulants1=this.postulantRepository.findById(Id_postulant).orElseThrow();
        postulants1.setNom(postulants.getNom());
        return postulantRepository.save(postulants1);
    }

    @Override
    public String SupprimerbyId(Integer Id_postulant) {
         this.postulantRepository.deleteById(Id_postulant);
         return "Supprimé avec succes";
    }
}
