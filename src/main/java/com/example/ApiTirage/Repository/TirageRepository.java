package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Postulants;
import com.example.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Transient;
import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

    @Query(value = "SELECT * FROM `tirage` WHERE libelle_tirage= ?1", nativeQuery = true)
    List<Tirage> findAll(String libelle_tirage);

    @Query(value =" SELECT postulants.prenom, postulants.nom, postulants.numero, postulants.email," +
            " tirage.date_tirage, tirage.libelle_tirage from list_import, postulants , tirage,postulants_tirages" +
            " WHERE postulants.id_postulant= postulants_tirages.postulants_id_postulant AND" +
            " tirage.id_tirage= postulants_tirages.tirages_id_tirage AND list_import.id_list=" +
            " postulants.list_import_id_list AND tirage.id_tirage = :id",nativeQuery = true)
    List<Object> findAllByLibelleListe(long id);
}
