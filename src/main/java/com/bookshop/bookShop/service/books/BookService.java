package com.bookshop.bookShop.service.books;

import com.bookshop.bookShop.DTO.BookDTO;
import com.bookshop.bookShop.entity.book.BookEntity;
import com.bookshop.bookShop.mapper.BookMapper;
import com.bookshop.bookShop.repository.books.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Optional<List<BookDTO>> getAll() throws Exception {
        List<BookEntity> entity = (List<BookEntity>) bookRepository.findAll();
        if(entity.isEmpty()){
            throw new Exception("No registered books found");
        }
        return Optional.of(
                entity.stream()
                        .map(bookMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    public void createBook(BookEntity bookEntity){
        bookRepository.save(bookEntity);
    }
}
