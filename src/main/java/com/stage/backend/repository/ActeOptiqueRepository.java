package com.stage.backend.repository;

import com.stage.backend.entity.ActeOptique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActeOptiqueRepository  extends CrudRepository<ActeOptique,Long> {

}
