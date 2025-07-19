package com.bookshop.bookShop.entity.author;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.List;

import static org.hibernate.type.SqlTypes.JSON;

@Entity
@Table(name = "g_authors")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", columnDefinition = "text")
    private String name;
    @Column(name = "description", columnDefinition = "jsonb")
    @JdbcTypeCode(JSON)
    private List<String> description;
    @Column(name = "photo", columnDefinition = "text")
    private String photo;
}
