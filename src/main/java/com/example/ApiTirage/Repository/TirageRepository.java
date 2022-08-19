package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

}
