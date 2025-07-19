package com.bookshop.bookShop.service.genre;

import com.bookshop.bookShop.entity.genre.GenreEntity;
import com.bookshop.bookShop.repository.genre.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService{
    private final GenreRepository genreRepository;
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public void createGenre(GenreEntity genre){
        this.genreRepository.save(genre);
    }
}
