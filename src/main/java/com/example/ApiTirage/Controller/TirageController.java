package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Tirage;
import com.example.ApiTirage.Services.ListeService;
import com.example.ApiTirage.Services.PostulantServices;
import com.example.ApiTirage.Services.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/tirage")
@CrossOrigin(origins = "http://localhost:4200/")
public class TirageController {
    private final TirageService tirageService;
    private final ListeService listeService;
    @Autowired
    PostulantServices postulantServices;

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


    @PostMapping("/{libelle_tirage}/{nombre}")
    public Object  create(@PathVariable("libelle_tirage") String libelle, @PathVariable("nombre") int nbre){
        ListImport listImport=listeService.recuperer(libelle);
        if(listImport !=null){
            Tirage tirage=new Tirage();
            tirage.setNombre_personnes(nbre);
            tirage.setLibelle_tirage(libelle);
            tirage.setDate_tirage(new Date());

            return tirageService.faireTirage(tirage,postulantServices.liste(listImport),nbre);
        }else{
            return "liste inexistante";
        }
    }
}
