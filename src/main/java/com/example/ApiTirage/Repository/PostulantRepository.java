package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantRepository extends JpaRepository<Postulants,Long> {
}
