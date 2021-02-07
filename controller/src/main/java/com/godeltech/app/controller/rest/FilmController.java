package com.godeltech.app.controller.rest;

import com.godeltech.app.controller.dto.DateAndLastNameSearcherDto;
import com.godeltech.app.controller.dto.FilmDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Film;
import com.godeltech.app.service.AbstractFilmService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    
    private final AbstractFilmService abstractFilmService;
    
    private final AbstractionMapDto <FilmDto, Film> filmMapperDto;
    
    public FilmController(@Qualifier("filmService") AbstractFilmService abstractFilmService,AbstractionMapDto<FilmDto, Film> filmMapperDto) {
        this.abstractFilmService = abstractFilmService;
        this.filmMapperDto = filmMapperDto;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> postFilm(@RequestBody FilmDto filmDto) throws Exception {
        final FilmDto dto = filmMapperDto
                .entityToDto(abstractFilmService.create(filmMapperDto.dtoToEntity(filmDto)));
        return dto != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<?>> getAllFilm() {
        final List<FilmDto> filmDtoList = filmMapperDto.convertEntityToDTOList(abstractFilmService.getAll());
        return filmDtoList != null && !filmDtoList.isEmpty() ? new ResponseEntity<>(filmDtoList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable("id") Integer id, @RequestBody FilmDto filmDto) throws Exception {
        final FilmDto dto = filmMapperDto.entityToDto(abstractFilmService.update(filmMapperDto.dtoToEntity(filmDto)));
        return dto != null ? new ResponseEntity<>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFilmById(@PathVariable(name = "id") Integer id) throws Exception {
        final boolean deleted = abstractFilmService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
    @GetMapping(value = "/sort/dates")
    public ResponseEntity<List<?>> sortBetweenDates(@RequestBody DateAndLastNameSearcherDto dateAndLastNameSearcherDto) {
        final List<FilmDto> sortFilmByDateList = filmMapperDto.convertEntityToDTOList(abstractFilmService.getAllBetweenDates(dateAndLastNameSearcherDto.getStartDate(),dateAndLastNameSearcherDto.getEndDate()));
        return sortFilmByDateList != null && !sortFilmByDateList.isEmpty() ? new ResponseEntity<>(sortFilmByDateList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "/sort/lastNameAndDates")
    public ResponseEntity<List<?>> sortByLastNameAndDate(@RequestBody DateAndLastNameSearcherDto dateAndLastNameSearcherDto) {
        final List<FilmDto> sortFilmByDateList = filmMapperDto.convertEntityToDTOList(abstractFilmService.findByDirectorAndReleaseDateBetween(dateAndLastNameSearcherDto.getLastName(),dateAndLastNameSearcherDto.getStartDate(),dateAndLastNameSearcherDto.getEndDate()));
        return sortFilmByDateList != null && !sortFilmByDateList.isEmpty() ? new ResponseEntity<>(sortFilmByDateList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}

