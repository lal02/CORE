package com.lalbr.core.media;

import java.util.ArrayList;
import java.util.List;

public enum Genre {
    // Aufteilen auf Game Movie Book Genres => mit funktionen zum retrieven

    // book genres
    Fantasy,
    SciFi,
    Krimi,
    Thriller,
    Horror,
    Romantik,
    Abentauer,
    Biografie,
    Sachbuch,
    Historischer_Roman,


    // game genre
    FPS,
    Platformer,
    OpenWorld,
    RPG,
    Survival,
    Simulation,
    Strategy,
    //Horror,
    Sandbox,
    MMO,
    PartyGame,


    //movie genre
    Comedy,
    Action,
    Abenteuer,
    //Horror,
    //Thriller,
    //SciFi,
    //Fantasy,
    //Krimi,
    Dokumentation,
    Drama;




    public Genre[] getBookGenres(){
        return new Genre[]{
                Fantasy,
                SciFi,
                Krimi,
                Thriller,
                Horror,
                Romantik,
                Abentauer,
                Biografie,
                Sachbuch,
                Historischer_Roman
        };
    }

    public Genre[] getGameGenres(){
        return new Genre[]{
                FPS,
                Platformer,
                OpenWorld,
                RPG,
                Survival,
                Simulation,
                Strategy,
                Horror,
                Sandbox,
                MMO,
                PartyGame,
        };
    }

    public Genre[] getMovieGenres(){
        return new Genre[]{
                Comedy,
                Action,
                Abenteuer,
                Horror,
                Thriller,
                SciFi,
                Fantasy,
                Krimi,
                Dokumentation,
                Drama
        };
    }
}
