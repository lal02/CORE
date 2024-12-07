package com.lalbr.core.repository.media;

import com.lalbr.core.model.media.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel,Long> {
}
