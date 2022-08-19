package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Services.ListeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Component
@RequestMapping("/liste")
@RestController
public class ListeController {
    private final ListeService listeService;

    @PostMapping("/ajouter")
    public ListImport creer(@RequestBody ListImport list){
        return listeService.ajouter(list);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id_list){
        return listeService.supprimer(id_list);
    }

    @GetMapping("/afficher")
    public List<ListImport> afficher(){
        return listeService.lister();
    }
}
