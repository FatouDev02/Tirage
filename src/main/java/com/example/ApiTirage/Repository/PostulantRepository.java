package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.ListImport;
import com.example.ApiTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulantRepository extends JpaRepository<Postulants,Long> {

    //recuperer le postulant par la liste
    List<Postulants> findByListImport(ListImport listImport);

    @Query(value = "SELECT * FROM postulants WHERE list_import_id_list = ?1", nativeQuery = true)
    List<Postulants> findAll(long id_list);
}
