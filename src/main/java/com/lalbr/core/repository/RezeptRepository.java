package com.lalbr.core.repository;

import com.lalbr.core.model.RezeptModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezeptRepository extends JpaRepository<RezeptModel,Long> {

    RezeptModel findRezeptModelByName(String name);
}
