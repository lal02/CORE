package com.lalbr.learnifyTools.services;

import com.lalbr.learnifyTools.model.FinEngModel;
import com.lalbr.learnifyTools.repository.FinEngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinEngService {
    @Autowired
    private FinEngRepository finEngRepository;

    public FinEngModel saveFinEngModel(FinEngModel finEngModel) {
        return finEngRepository.save(finEngModel);
    }

    public Optional<FinEngModel> getFinEngModelById(Long id) {
        return finEngRepository.findById(id);
    }

    public List<FinEngModel> getAllFinEngModels() {
        return finEngRepository.findAll();
    }
}
