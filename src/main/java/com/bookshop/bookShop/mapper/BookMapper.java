package com.bookshop.bookShop.mapper;

import com.bookshop.bookShop.DTO.BookDTO;
import com.bookshop.bookShop.entity.book.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookEntity toEntity(BookDTO bookDTO);
    BookDTO toDTO(BookEntity entity);
}
