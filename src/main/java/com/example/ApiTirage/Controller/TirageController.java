package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Services.ListeService;
import com.example.ApiTirage.Services.PostulantServices;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
@RestController
@RequestMapping("/tirage")
@CrossOrigin
public class TirageController {
    private final TirageService tirageService;
    private final PostulantServices postulantServices;
    private final ListeService listeService;
    private final ListeController listeController;


    @PostMapping("/add")
    public Tirage creer(@RequestBody Tirage tirage){

        return tirageService.creer(tirage);
    }





    @PostMapping("/add/{libelle_tirage}/{Nbredepostulants}/{libelle}")
    public Object create(@PathVariable("libelle_tirage") String libelle_tirage, @PathVariable("libelle") String libelle, @PathVariable("Nbredepostulants") int nbre, @RequestParam("file") MultipartFile file){
        ListImport list=new ListImport();
        list.setLibelle(libelle);
        listeController.creerliste(file,list);

        ListImport liste = listeService.recuperer(libelle);
            //ListImport listImport=listeService.recuperer(libelle_tirage);
            if(liste !=null){
                Tirage t=new Tirage();
                t.setLibelle_tirage(libelle_tirage);
                t.setDate_tirage(new Date());
                t.setNbredepostulants(nbre);

                return tirageService.creerTirage(t,postulantServices.liste(liste),nbre);

            }
            else {
                return "Cette liste n'existe pas!";
            }

       // List<Postulants> liste_trie = tirageService.faireTirage(liste.getListe_postulant());

    }
/////////////////////////////////////////////////////////////////
    @PostMapping("/{libelle_tirage}/{Nbredepostulants}/{libelle}")
    public Object createtirageaveclisteexistant(@PathVariable("libelle_tirage") String libelle_tirage, @PathVariable("libelle") String libelle, @PathVariable("Nbredepostulants") int nbre){
//        ListImport list=new ListImport();
//        list.setLibelle(libelle);
//        listeController.creerliste(file,list);

        ListImport liste = listeService.recuperer(libelle);
        //ListImport listImport=listeService.recuperer(libelle_tirage);
        if(liste !=null){
            Tirage t=new Tirage();
            t.setLibelle_tirage(libelle_tirage);
            t.setDate_tirage(new Date());
            t.setNbredepostulants(nbre);
            return tirageService.creerTirage(t,postulantServices.liste(liste),nbre);
        }
        else {
            return "Cette liste n'existe pas!";
        }

        // List<Postulants> liste_trie = tirageService.faireTirage(liste.getListe_postulant());

    }
//////////////////////////////////////////////////////
@GetMapping("/ntirage")

public String nombretirage() {
    return tirageService.nombretirage();
}

    @GetMapping("/ntirageliste")

    public String nombretirageparliste() {
        return tirageService.nombretirageparliste();
    }

    @PostMapping("/{libelle}/{nombre_personnes}")
    public List<Postulants> faireLeTrie(@PathVariable String libelle, @PathVariable int nombre_personnes){
        ListImport liste = listeService.recuperer(libelle);

        List<Postulants> liste_trie = tirageService.faireTirage(liste.getListe_postulant(), nombre_personnes);
        return liste_trie;
    }


    @DeleteMapping("/delete/{id_tirage}")
    public String supprimer(@PathVariable Long id_tirage){
        return tirageService.supprimer(id_tirage);
    }

    @GetMapping("/list")
    public List<Tirage> lister(){

        return tirageService.liste();
    }





}
