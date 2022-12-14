package com.example.ApiTirage.Controller;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Services.ListeService;
import com.example.ApiTirage.Services.PostulantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Postulant")
@CrossOrigin
public class PostulantsController {
    @Autowired
    PostulantServices postulantServices;

    @Autowired
    ListeService listeService;
    @PostMapping("/add")
    public Postulants ajout(@RequestBody Postulants postulants) {

        return this.postulantServices.Ajout(postulants);
    }

    @GetMapping("/list/{id}")
    public List<Postulants> l(@PathVariable Long id) {
        ListImport l=listeService.afficherParId(id);
        return postulantServices.liste(l);
    }

    @GetMapping("/afficher")
    public List<Postulants> l() {

        return postulantServices.lister();
    }

    @PutMapping("/update/{Id_postulant}")
    public String update(@RequestBody Postulants postulants, @PathVariable Long Id_postulant) {
        this.postulantServices.Modifier(postulants, Id_postulant);
        return "Mise à jours validée";

    }

    @DeleteMapping("/delete/{Id_Postulant}")
    public String delete(@PathVariable Long Id_postulant) {
        postulantServices.SupprimerbyId(Id_postulant);
        return "Postulant supprimé!!!";
    }


}