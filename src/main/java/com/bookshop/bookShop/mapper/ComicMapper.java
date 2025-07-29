package com.bookshop.bookShop.mapper;

import com.bookshop.bookShop.DTO.ComicDTO;
import com.bookshop.bookShop.entity.comics.ComicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ComicMapper {
    ComicMapper INSTANCE = Mappers.getMapper(ComicMapper.class);

    ComicEntity toEntity(ComicDTO comicDTO);
    ComicDTO toDTO(ComicEntity entity);
}
