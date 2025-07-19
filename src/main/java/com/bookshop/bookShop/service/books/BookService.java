package com.bookshop.bookShop.service.books;

import com.bookshop.bookShop.entity.book.BookEntity;
import com.bookshop.bookShop.repository.books.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Optional<List<BookEntity>> getAll(){
        return Optional.of((List<BookEntity>) bookRepository.findAll());
    }

    public void createBook(BookEntity bookEntity){
        bookRepository.save(bookEntity);
    }
}
