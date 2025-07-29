package com.bookshop.bookShop.controller.comics;

import com.bookshop.bookShop.DTO.ComicDTO;
import com.bookshop.bookShop.service.comics.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ComicController {
    @Autowired
    private ComicService comicService;

    @PostMapping("/comic-create")
    public void createComic(@RequestBody ComicDTO comicDTO) {
        comicService.createComic(comicDTO);
    }

    @GetMapping("/comic-all")
    public ResponseEntity listComic() throws Exception {
        var listComicEntities = this.comicService.getAllComic();
        if(listComicEntities.isEmpty()){
            return new ResponseEntity<>("No registered comics found", HttpStatus.FOUND);
        }

        return new ResponseEntity<>(listComicEntities.get(), HttpStatus.OK);
    }
}
