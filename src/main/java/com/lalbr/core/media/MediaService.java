package com.lalbr.core.media;

import com.lalbr.core.media.book.BookModel;
import com.lalbr.core.media.book.BookRepository;
import com.lalbr.core.media.book.BookSeriesModel;
import com.lalbr.core.media.book.BookSeriesRepository;
import com.lalbr.core.media.game.GameModel;
import com.lalbr.core.media.game.GameRepository;
import com.lalbr.core.media.movie.MovieModel;
import com.lalbr.core.media.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookSeriesRepository bookSeriesRepository;

    public List<BookModel> findAllBookModel(){
        return bookRepository.findAll();
    }

    public BookModel findBookModelByTitle(String name){
        return bookRepository.findByTitle(name);
    }

    public List<BookSeriesModel> findAllBookSeriesModel(){
        return bookSeriesRepository.findAll();
    }

    public BookSeriesModel findBookSeriesModelByTitle(String name){
        return bookSeriesRepository.findByTitle(name);
    }

    public List<MovieModel> findAllMovieModel(){
        return movieRepository.findAll();
    }
    public MovieModel findMovieModelByTitle(String name){
        return movieRepository.findByTitle(name);
    }

    public GameModel findGameModelByTitle(String name){
        return gameRepository.findByTitle(name);
    }
    public List<GameModel> findAllGameModel(){
        return gameRepository.findAll();
    }

}
