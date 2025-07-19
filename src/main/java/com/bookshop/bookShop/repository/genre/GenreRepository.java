package com.bookshop.bookShop.repository.genre;

import com.bookshop.bookShop.entity.genre.GenreEntity;
import org.springframework.data.repository.CrudRepository;


public interface GenreRepository extends CrudRepository<GenreEntity, Long> {

}
