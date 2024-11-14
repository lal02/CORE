package com.lalbr.core.controller;

import com.lalbr.core.model.FinEngModel;
import com.lalbr.core.services.FinEngService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "wordstorage";
    }


    @PostMapping("/wordstorage")
    public ResponseEntity<FinEngModel> createMyModel(@RequestBody FinEngModel myModel) {
        FinEngModel savedModel = finEngService.saveFinEngModel(myModel);
        return ResponseEntity.ok(savedModel); // Return the saved model
    }
}
