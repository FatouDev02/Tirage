package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.ListImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListeRepository extends JpaRepository<ListImport, Long> {

//recuperer la liste par son libelle
    ListImport findByLibelle(String libelle);
    @Query(value = "select count(*) from list_import where list_import.nombre_tirage !=0",nativeQuery = true)
    public int FIND_LIST_TRIEE();
}
