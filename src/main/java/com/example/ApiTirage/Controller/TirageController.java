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

    @PostMapping("/add")
    public Tirage creer(@RequestBody Tirage tirage){

        return tirageService.creer(tirage);
    }

    @DeleteMapping("/delete/{id_tirage}")
    public String supprimer(@PathVariable Long id_tirage){
        return tirageService.supprimer(id_tirage);
    }

    @GetMapping("/list")
    public List<Tirage> lister(){

        return tirageService.liste();
    }



    @GetMapping("/list/{id_liste}/{nombre_personnes}")
    public List<Postulants> faireLeTrie(@PathVariable("id_liste") Long id_liste, @PathVariable("nombre_personnes") Long nombre_personnes){
        ListImport liste = listeService.recuperer(id_liste);
        List<Postulants> liste_trie = tirageService.faireTirage(liste.getListe_postulant(), nombre_personnes);

        System.out.println(liste);
        return liste_trie;
    }

}
