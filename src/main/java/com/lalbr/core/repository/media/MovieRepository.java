package com.lalbr.core.repository.media;

import com.lalbr.core.model.media.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel,Long> {

}
