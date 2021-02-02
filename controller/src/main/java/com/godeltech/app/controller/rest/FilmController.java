package com.godeltech.app.controller.rest;

import com.godeltech.app.controller.dto.FilmDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Film;
import com.godeltech.app.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dmitry Chueshov 28.01.2021 15:33
 * @project application
 */

@RestController
@RequestMapping(value = "/film")

public class FilmController {
    
    private final FilmService filmService;
    
    private final AbstractionMapDto <FilmDto, Film> filmMapperDto;
    
    public FilmController(FilmService filmService,AbstractionMapDto<FilmDto, Film> filmMapperDto) {
        this.filmService = filmService;
        this.filmMapperDto = filmMapperDto;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> postDirector(@RequestBody FilmDto filmDto) {
        final FilmDto dto = filmMapperDto
                .entityToDto(filmService.create(filmMapperDto.dtoToEntity(filmDto)));
        return dto != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<?>> getAllDirector() {
        final List<FilmDto> filmDtoList = filmMapperDto.convertEntityToDTOList(filmService.getAll());
        return filmDtoList != null && !filmDtoList.isEmpty() ? new ResponseEntity<>(filmDtoList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable("id") Integer id, @RequestBody FilmDto filmDto) throws Exception {
        final FilmDto dto = filmMapperDto.entityToDto(filmService.update(filmMapperDto.dtoToEntity(filmDto)));
        return dto != null ? new ResponseEntity<>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable(name = "id") Integer id) {
        final boolean deleted = filmService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
}

