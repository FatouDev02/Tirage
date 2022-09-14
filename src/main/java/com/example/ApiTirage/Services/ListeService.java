package com.example.ApiTirage.Services;

import com.example.ApiTirage.Models.ListImport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListeService {
    ListImport ajouter(ListImport listImport);

    ListImport modifierliste(long id);

    ListImport afficherParLibelle(String libelle);
    String supprimer(Long id_list);

    List<ListImport> lister();

    ListImport recuperer(String libelle);
}
