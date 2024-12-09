package com.lalbr.core.services;

import com.lalbr.core.model.media.BookModel;
import com.lalbr.core.repository.media.BookRepository;
import com.lalbr.core.repository.media.GameRepository;
import com.lalbr.core.repository.media.MovieRepository;
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


    public List<BookModel> findAllBookModel(){
        return bookRepository.findAll();
    }

    public BookModel findBookModelByTitle(String name){
        return bookRepository.findByTitle(name);
    }

}
