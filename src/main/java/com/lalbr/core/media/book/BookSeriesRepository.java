package com.lalbr.core.media.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSeriesRepository extends JpaRepository<BookSeriesModel,Long> {
    BookSeriesModel findByTitle(String title);

}
