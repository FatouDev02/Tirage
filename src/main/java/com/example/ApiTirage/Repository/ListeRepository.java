package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.ListImport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListeRepository extends JpaRepository<ListImport, Long> {

    ListImport findByLibelle(String libelle);
}
