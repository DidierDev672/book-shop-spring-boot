package com.bookshop.bookShop.service.genre;

import com.bookshop.bookShop.entity.genre.GenreEntity;
import com.bookshop.bookShop.repository.genre.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService{
    private final GenreRepository genreRepository;
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public void createGenre(GenreEntity genre){
        this.genreRepository.save(genre);
    }

    public Optional<List<GenreEntity>> getAll() throws Exception {
        List<GenreEntity> entity = (List<GenreEntity>) genreRepository.findAll();
        if(entity.isEmpty()){
            throw new Exception("No literary genres were recorded");
        }

        return Optional.of(entity.stream().collect(Collectors.toList()));
    }
}
