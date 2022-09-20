package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Repository.ListeRepository;
import com.example.ApiTirage.Services.ListeService;
import com.example.ApiTirage.Services.PostulantServices;
import com.example.ApiTirage.excel.ExcelFileConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@Component
@RequestMapping("/liste")
@RestController
@CrossOrigin
public class ListeController {
    @Autowired
    ListeService listeService;
    @Autowired
    PostulantServices postulantServices;
    @Autowired
    ListeRepository listeRepository;

//    @PostMapping("/add")
//    public ListImport creer(@RequestBody ListImport list){
//        return listeService.ajouter(list);
//    }
@GetMapping("/listtriees")
public int ltrie(){
    return listeRepository.FIND_LIST_TRIEE();
}

    @PostMapping("/add/{libelle}")
    public String creerliste(
            @RequestParam("file") MultipartFile var_file, ListImport list
            ) {
    //@PathVariable(value = "libelle") String var_libelle
        System.out.println(var_file.getOriginalFilename());
        //on vérifie si le fichier fournit est de type excel avec la methode verifier
        // dans la classe axcelfileconfig
        if(ExcelFileConfig.verifier(var_file)){
            //verification si la liste existe dans la bdd par nom ou libelle
            ListImport listImport = listeService.recuperer(list.getLibelle());
            if(listImport == null){
                // si la liste n'existe pas on la crie
                ListImport var_list= new ListImport();
                var_list.setDateimport(new Date());//on donne la date
                var_list.setLibelle(list.getLibelle());// on donne le libelle

                //on récupère la date et le libelle donné au nouvel objet listimpor1
                ListImport listImport1=listeService.ajouter(var_list);
                //apres la creation on récupère les postull du fichier
                // excel dans une liste "postulantslist"

                List<Postulants> postulantsList = ExcelFileConfig.postulantsExcel(var_file);

                //on parcourt la liste par une boucle for compteur p
                for (Postulants p: postulantsList){
                    if(p.getEmail()!=null & p.getNom()!=null){
                        p.setListImport(listImport1);
                        postulantServices.Ajout(p);
                    }

                }
            }
        }
    return "Liste enregistrée";
    }

    @DeleteMapping("/delete/{id_list}")
    public String supprimer(@PathVariable Long id_list){
        return listeService.supprimer(id_list);
    }

    @GetMapping("/list")
    public List<ListImport> afficher(){

        return listeService.lister();
    }
}
