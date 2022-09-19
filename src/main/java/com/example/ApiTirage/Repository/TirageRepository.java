package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {


    @Query(value = " select distinct tirage.* FROM tirage,list_import,postulant_tirage,postulants where (postulant_tirage.tirage_id = tirage.id_tirage and postulants.list_import_id_list=list_import.id_list and" +
            " postulants.id_postulant = postulant_tirage.postulant_id and" +
            " list_import.id_list=:id_list)",nativeQuery = true)
    List<Tirage> FIND_TIRAGE_BY_LISTE_ID( Long id_list);

    @Query(value = "select count(distinct(pt.tirage_id)) from list_import lp, tirage t, postulants p, postulant_tirage pt where lp.id_list = p.list_import_id_list and" +
            " pt.postulant_id = p.id_postulant and" +
            " t.id_tirage = pt.tirage_id and" +
            " lp.id_list=:id_list)",nativeQuery = true)
    Object NBRETIRAGE_BY_LISTE_ID( Long id_list);

    @Query(value =
            "select count(*),list_import.id_list,libelle,dateimport from postulant_tirage,postulants,tirage,list_import where postulants.id_postulant = postulant_tirage.postulant_id and " +
            "tirage.id_tirage = postulant_tirage.tirage_id and " +
            "postulants.list_import_id_list = list_import.id_list group by list_import.id_list " ,nativeQuery = true)
    List<Object> FIND_NBRETIRAGE_BY_LISTE_ID();

    @Query(value = "select count(id_tirage) from tirage ",nativeQuery = true)
    public String NOMBRE_TIRAGE_TOTAL();

    @Query(value = " SELECT   postulants.nom,postulants.prenom,postulants.email,postulants.numero,postulants.list_import_id_list FROM `postulant_tirage`,`postulants`WHERE\n" +
            "postulants.id_postulant = postulant_tirage.postulant_id AND postulant_tirage.tirage_id =:id_tirage",nativeQuery = true)
    List<Object> FIND_POSTRIRE_BY_IDTIRAGE(Long id_tirage);

    //select count(distinct(pt.tirage_id)) from list_import lp, tirage t, postulants p, postulant_tirage pt where lp.id_list = p.list_import_id_list and pt.postulant_id = p.id_postulant and t.id_tirage = pt.tirage_id and lp.id_list=2;


}
