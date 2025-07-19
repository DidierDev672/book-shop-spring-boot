package com.bookshop.bookShop.controller.genre;

import com.bookshop.bookShop.entity.genre.GenreEntity;
import com.bookshop.bookShop.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/genre-create")
    public void createGenre(@RequestBody GenreEntity genre){
        genreService.createGenre(genre);
    }
}
