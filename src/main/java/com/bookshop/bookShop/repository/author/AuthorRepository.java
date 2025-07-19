package com.bookshop.bookShop.repository.author;

import com.bookshop.bookShop.entity.author.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
}
