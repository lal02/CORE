package com.lalbr.learnifyTools.repository;

import com.lalbr.learnifyTools.model.FinEngModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinEngRepository extends JpaRepository<FinEngModel, Long> {
}
