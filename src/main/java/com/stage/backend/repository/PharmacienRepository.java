package com.stage.backend.repository;

import com.stage.backend.entity.Pharmacien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacienRepository extends JpaRepository<Pharmacien,Long> {

    Optional<Pharmacien> findById(Long aLong);

    Boolean existsByEmail(String email);

    @Query("select p from Pharmacien p where p.email=:email")
    public Pharmacien findByEmail(@Param("email")String email);

    @Query("select DISTINCT p from Pharmacien p where p.isActivated = false ")
    public List<Pharmacien> getAllPharamcien();


}
