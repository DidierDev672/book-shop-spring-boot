package com.bookshop.bookShop.controller.books;

import com.bookshop.bookShop.DTO.BookDTO;
import com.bookshop.bookShop.entity.book.BookEntity;
import com.bookshop.bookShop.service.books.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book-all")
    public Optional<List<BookDTO>> getAll() throws Exception{
        return bookService.getAll();
    }

    @PostMapping("/book-create")
    public void createBook(@RequestBody BookEntity entity){
        bookService.createBook(entity);
    }
}
