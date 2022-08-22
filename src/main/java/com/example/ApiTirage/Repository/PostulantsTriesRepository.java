package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.PostulantsTries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantsTriesRepository extends JpaRepository<PostulantsTries, Long> {
}
