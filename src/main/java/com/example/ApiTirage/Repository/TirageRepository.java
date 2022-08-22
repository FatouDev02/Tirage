package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {

}
