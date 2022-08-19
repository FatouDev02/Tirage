package com.example.ApiTirage.Services.Impl;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Repository.ListeRepository;
import com.example.ApiTirage.Services.ListeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ListeServiceImpl implements ListeService {
    private final ListeRepository listeRepository;
    @Override
    public ListImport ajouter(ListImport list) {
        return listeRepository.save(list);
    }

    @Override
    public String supprimer(Long id_list) {
        listeRepository.deleteById(id_list);
        return "La liste a été supprimée avec succée !";
    }

    @Override
    public List<ListImport> lister() {
        return listeRepository.findAll();
    }
}
