package com.bookshop.bookShop.DTO;

import com.bookshop.bookShop.entity.author.AuthorEntity;
import com.bookshop.bookShop.entity.genre.GenreEntity;

import java.util.List;

public class ComicDTO {
    private Long id;
    private String name;
    private List<AuthorEntity> authors;
    private List<GenreEntity> genres;
    private List<String> description;
    private String photo;

    public ComicDTO(){}

    public ComicDTO(
            Long id,
            String name,
            List<AuthorEntity> authors,
            List<GenreEntity> genres,
            List<String> description,
            String photo
    ){
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.genres = genres;
        this.description = description;
        this.photo = photo;
    }

    public static ComicDTO init(
            Long id,
            String name,
            List<AuthorEntity> authors,
            List<GenreEntity> genres,
            List<String> description,
            String photo
    ){
        return new ComicDTO(id, name, authors, genres, description, photo);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
