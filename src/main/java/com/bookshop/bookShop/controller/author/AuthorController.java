package com.bookshop.bookShop.controller.author;

import com.bookshop.bookShop.entity.author.AuthorEntity;
import com.bookshop.bookShop.service.authors.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/author-create")
    public void createAuthor(@RequestBody AuthorEntity authorEntity){
        authorService.createAuthor(authorEntity);
    }
}
