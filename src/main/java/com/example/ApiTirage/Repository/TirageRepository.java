package com.example.ApiTirage.Repository;

import com.example.ApiTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Transient;

public interface TirageRepository extends JpaRepository<Tirage, Long> {


    @Query (value = "SELECT COUNT(id_tirage) FROM tirage",nativeQuery = true)
   public String nombredetirage();

    @Query (value = "select count (id_tirage) FROM tirage",nativeQuery = true)
    public String nombreTirageParliste();


}
