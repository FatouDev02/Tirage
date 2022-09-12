package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.ListImport;
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
    public List<Postulants> lister() {
        return postulantRepository.findAll();
    }

    @Override
    public Object recupParliste(long id_list) {
        List<Postulants> retrouve = postulantRepository.findAll(id_list);
//            System.out.println(retrouve);
        if (retrouve.size() != 0) {
            return retrouve;
        }else{
            return "Désolé ce cette liste introuvable !!";
        }
    }

    @Override
    public List<Postulants> liste(ListImport listImport) {
        return postulantRepository.findByListImport(listImport);
    }


    @Override
    public Postulants Modifier(Postulants postulants, Long Id_postulant) {

        return postulantRepository.findById((long) Math.toIntExact(Id_postulant))
                .map(postulants1 -> {
                    postulants1.setNom(postulants.getNom());
                    postulants1.setPrenom(postulants.getPrenom());
                    postulants1.setEmail(postulants.getEmail());
                    postulants1.setNumero(postulants.getNumero());
                    return postulantRepository.save(postulants1);
                }).orElseThrow(() -> new RuntimeException("Cet postulant n'existe pas"));


    }

    @Override
    public String SupprimerbyId(Long Id_postulant) {
         this.postulantRepository.deleteById(Id_postulant);
         return "Supprimé avec succes";
    }




}
