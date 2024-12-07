package com.lalbr.core.repository.media;

import com.lalbr.core.model.media.BookModel;
import com.lalbr.core.model.media.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {
}
