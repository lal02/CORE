package com.lalbr.core.services;

import com.lalbr.core.model.RezeptModel;
import com.lalbr.core.repository.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezeptService {

    @Autowired
    private RezeptRepository rezeptRepository;


    public RezeptModel findRezeptModelByName(String name) {
        return rezeptRepository.findRezeptModelByName(name);
    }

    public List<RezeptModel> findAllRezeptModel() {
        return rezeptRepository.findAll();
    }

}
