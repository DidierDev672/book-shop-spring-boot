package com.bookshop.bookShop.repository.comics;

import com.bookshop.bookShop.entity.comics.ComicEntity;
import org.springframework.data.repository.CrudRepository;

public interface ComicRepository extends CrudRepository<ComicEntity, Long> {
}
