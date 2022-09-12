package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Repository.ListeRepository;
import com.example.ApiTirage.Services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ListeServiceImpl implements ListeService {
    @Autowired
    ListeRepository listeRepository;

    @Override
    public ListImport ajouter(ListImport list) {
        return listeRepository.save(list);
    }

    @Override
    public ListImport modifierliste(ListImport listImport) {
        return null;
    }

    @Override
    public ListImport afficherParId(Long id_list) {
        return this.listeRepository.findById(id_list).get();
    }


    @Override
    public String supprimer(Long id_list) {
        listeRepository.deleteById(id_list);
        return "La liste a été supprimée avec succès !";
    }

    @Override
    public List<ListImport> lister() {
        return listeRepository.findAll();
    }

    @Override
    public ListImport recuperer(String libelle) {
        ListImport listImport=listeRepository.findByLibelle(libelle);
        //ListImport liste_recuperer = listeRepository.findById(id_liste).orElseThrow();
        return listImport;
    }
}
