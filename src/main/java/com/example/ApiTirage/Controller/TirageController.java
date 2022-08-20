package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Services.ListeService;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@AllArgsConstructor
@RestController
@RequestMapping("/tirage")
public class TirageController {
    private final TirageService tirageService;
    private final ListeService listeService;

    @PostMapping("/creer")
    public Tirage creer(@RequestBody Tirage tirage){
        return tirageService.creer(tirage);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id_tirage){
        return tirageService.supprimer(id_tirage);
    }

    @GetMapping("/lister")
    public List<Tirage> lister(){
        return lister();
    }

    @GetMapping("/tirage/{id_liste}/{nombre}")
    public List<Postulants> faireLeTrie(@PathVariable Long id_liste, @PathVariable Long nombre){
        ListImport liste = listeService.recuperer(id_liste);

        List<Postulants> liste_trie = tirageService.faireTirage(liste.getListe_postulant(), nombre);
        return liste_trie;
    }
}
