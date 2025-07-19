package com.bookshop.bookShop.service.authors;

import com.bookshop.bookShop.entity.author.AuthorEntity;
import com.bookshop.bookShop.repository.author.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public void createAuthor(AuthorEntity authorEntity) {
        this.authorRepository.save(authorEntity);
    }
}
