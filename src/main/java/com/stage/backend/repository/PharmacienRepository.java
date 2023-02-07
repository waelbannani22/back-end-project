package com.stage.backend.repository;

import com.stage.backend.entity.Pharmacien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacienRepository extends JpaRepository<Pharmacien,Long> {

   // Optional<Pharmacien> findById(Long aLong);

    @Query("select p from Pharmacien p where p.email=:email")
    public Optional<Pharmacien> findByEmail(@Param("email")String email);
}
