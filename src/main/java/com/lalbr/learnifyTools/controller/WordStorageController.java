package com.lalbr.learnifyTools.controller;

import com.lalbr.learnifyTools.model.FinEngModel;
import com.lalbr.learnifyTools.services.FinEngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WordStorageController {
    @Autowired
    private FinEngService finEngService;

    @GetMapping("/wordstorage")
    public String wordStorageGetMapping(){
        System.out.println(finEngService.getFinEngModelById(2L).get());
        return "wordstorage";
    }


    @PostMapping("/wordstorage")
    public ResponseEntity<FinEngModel> createMyModel(@RequestBody FinEngModel myModel) {
        FinEngModel savedModel = finEngService.saveFinEngModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }
}
