package com.lalbr.core.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "words")
public class FinEngModel {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private int id;

    @Column(name = "finnish")
    private String finnishWord;
    @Column(name = "english")
    private String englishWord;


    public String getFinnishWord() {
        return finnishWord;
    }
    public void setFinnishWord(String finnishWord) {
        this.finnishWord = finnishWord;
    }
    public String getEnglishWord() {
        return englishWord;
    }
    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return finnishWord + " = " + englishWord + " "+ getId();
    }
}
