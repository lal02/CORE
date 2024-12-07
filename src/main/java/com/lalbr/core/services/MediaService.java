package com.lalbr.core.services;

import com.lalbr.core.repository.media.BookRepository;
import com.lalbr.core.repository.media.GameRepository;
import com.lalbr.core.repository.media.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    MovieRepository movieRepository;
}
