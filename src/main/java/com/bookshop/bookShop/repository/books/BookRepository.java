package com.bookshop.bookShop.repository.books;

import com.bookshop.bookShop.entity.book.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
