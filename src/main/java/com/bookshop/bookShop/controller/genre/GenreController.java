package com.bookshop.bookShop.controller.genre;

import com.bookshop.bookShop.entity.genre.GenreEntity;
import com.bookshop.bookShop.service.genre.GenreService;
import com.bookshop.bookShop.shared.response.CustomResponse;
import com.bookshop.bookShop.shared.response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/genre-create")
    public void createGenre(@RequestBody GenreEntity genre){
        genreService.createGenre(genre);
    }

    @GetMapping("/genre-all")
    public ResponseEntity<CustomResponse<?>> getAll() throws Exception {
        Optional<List<GenreEntity>> optionalGenres = genreService.getAll();
        if(optionalGenres.isEmpty()){
            return ResponseEntity.status(404).body(ResponseBuilder.buildErrorResponse("No genres found", HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.ok(ResponseBuilder.buildSuccessResponse(optionalGenres.get(), "Genres fetched successfully"));
    }
}
