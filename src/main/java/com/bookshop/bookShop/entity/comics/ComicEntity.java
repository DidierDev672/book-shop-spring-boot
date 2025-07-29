package com.bookshop.bookShop.entity.comics;

import com.bookshop.bookShop.entity.author.AuthorEntity;
import com.bookshop.bookShop.entity.genre.GenreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "g_comics")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ComicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "authors",  columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<AuthorEntity> authors;
    @Column(name = "genres", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<GenreEntity> genres;
    @Column(name = "description", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> description;
    @Column(name = "photo", columnDefinition = "text")
    private String photo;
}
