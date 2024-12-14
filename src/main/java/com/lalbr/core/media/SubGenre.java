package com.lalbr.core.media;

import static com.lalbr.core.media.Genre.Fantasy;

public enum SubGenre {



    //books - fantasy
    DarkFantasy, // eg Witcher
    HighFantasy, // eg LOTR
    LowFantasy, // eg HarryPotter
    ScienceFantasy,
    SwordandSorcery, // eg Conan der Barbar
    SteampunkFantasy,
    UrbanFantasy, //fantasy in urban settings
    EpicFantasy,
    MythicFantasy,
    GrimdarkFantasy, // eg GoT
    //books - sci fi
    HardSciFi, // realistischer
    SoftSciFi, // weniger realistisch
    Dystopia,
    Utopia,
    Cyberpunk,
    SpaceOpera, // eg star wars
    Postapokalyptisch,
    //books - abenteuer
    Exploration,
    Survival,
    Heldenreise,
    //books - sachbuch
    Informatik,
    Geschichte,
    //books - historischer Roman
    AlternativGeschichte,
    Kriegsgeschichte,

    //games - fps
    TaktischerShooter,
    ArenaShooter,
    HeroShooter,
    SurvivalShooter,
    HorrorShooter,
    LootingShooter,
    //games - platformer
    Platformer2D,
    Platformer3D,
    //games - openworld
    ActionAdventure_OpenWorld,
    Survival_OpenWorld,
    RPG_OpenWorld,
    Sandbox_OpenWorld,
    //games - RPG
    Action_RPG,
    TurnBased_RPG,
    Tactical_RPG,
    MMORPG,
    DungeonCrawler,
    Roguelike,
    //games - survival
    ZombieSurvival,
    CraftingSurvival,

    //movies - action
    Superhelden,
    HeistAction,
    MilitärAction;


    public SubGenre[] getBookFantasySubgenres(){
        return new SubGenre[]{
                DarkFantasy,
                HighFantasy,
                LowFantasy,
                ScienceFantasy,
                SwordandSorcery,
                SteampunkFantasy,
                UrbanFantasy,
                EpicFantasy,
                MythicFantasy,
                GrimdarkFantasy,
        };
    }

    public SubGenre[] getBookSciFiSubgenres(){
        return new SubGenre[]{
                HardSciFi,
                SoftSciFi,
                Dystopia,
                Utopia,
                Cyberpunk,
                SpaceOpera,
                Postapokalyptisch,
        };
    }

    public SubGenre[] getBookAbenteuerSubgenres(){
        return new SubGenre[]{
                Exploration,
                Survival,
                Heldenreise,
        };
    }

    public SubGenre[] getBookSachbuchSubgenres(){
        return new SubGenre[]{
                Informatik,
                Geschichte,
        };
    }

    public SubGenre[] getBookHistorischerRomanSubgenres(){
        return new SubGenre[]{
                AlternativGeschichte,
                Kriegsgeschichte
        };
    }
    public SubGenre[] getGamesFPSSubgenres(){
        return new SubGenre[]{
                TaktischerShooter,
                ArenaShooter,
                HeroShooter,
                SurvivalShooter,
                HorrorShooter,
                LootingShooter,
        };
    }

    public SubGenre[] getGamesPlatformerSubgenres(){
        return new SubGenre[]{
                Platformer2D,
                Platformer3D,
        };
    }

    public SubGenre[] getGamesOpenWorldSubgenres(){
        return new SubGenre[]{
                ActionAdventure_OpenWorld,
                Survival_OpenWorld,
                RPG_OpenWorld,
                Sandbox_OpenWorld,
        };
    }

    public SubGenre[] getGamesRPGSubgenres(){
        return new SubGenre[]{
                Action_RPG,
                TurnBased_RPG,
                Tactical_RPG,
                MMORPG,
                DungeonCrawler,
        };
    }
    public SubGenre[] getGamesSurvivalSubgenres(){
        return new SubGenre[]{
                ZombieSurvival,
                CraftingSurvival,
        };
    }
    public SubGenre[] getMoviesActionSubgenres(){
        return new SubGenre[]{
                Superhelden,
                HeistAction,
                MilitärAction
        };
    }
}
