package com.bookshop.bookShop.service.comics;

import com.bookshop.bookShop.DTO.ComicDTO;
import com.bookshop.bookShop.entity.comics.ComicEntity;
import com.bookshop.bookShop.mapper.ComicMapper;
import com.bookshop.bookShop.repository.comics.ComicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComicService {
    private final ComicRepository comicRepository;
    private final ComicMapper comicMapper;

    public ComicService(ComicRepository comicRepository, ComicMapper comicMapper){
        this.comicRepository = comicRepository;
        this.comicMapper = comicMapper;
    }

    public void createComic(ComicDTO comicDTO){
        ComicEntity comicEntity = comicMapper.toEntity(comicDTO);
        comicRepository.save(comicEntity);
    }

    public Optional<List<ComicDTO>> getAllComic() throws Exception {
        List<ComicEntity> comicEntities = (List<ComicEntity>) comicRepository.findAll();
        if(comicEntities.isEmpty()){
            throw new Exception("No registered comics found");
        }

        return Optional.of(
                comicEntities.stream()
                        .map(comicMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
