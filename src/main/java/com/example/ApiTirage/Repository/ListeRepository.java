package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.ListImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeRepository extends JpaRepository<ListImport, Long> {
}
