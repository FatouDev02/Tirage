package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulantRepository extends JpaRepository<Postulants,Long> {
    List<Postulants> findByListImport(Long id_list);
}

