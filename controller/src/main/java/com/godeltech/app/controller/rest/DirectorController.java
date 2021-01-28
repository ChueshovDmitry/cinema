package com.godeltech.app.controller.rest;

import com.godeltech.app.controller.dto.DirectorDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Director;
import com.godeltech.app.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Dmitry Chueshov 28.01.2021 15:33
 * @project application
 */

@RestController
@RequestMapping(value = "/director")

public class DirectorController {
    
    
    private final DirectorService directorService;
    private final AbstractionMapDto <DirectorDto, Director> directorMapperDto;
    
    public DirectorController(DirectorService directorService,
                              AbstractionMapDto<DirectorDto, Director> directorMapperDto) {
        this.directorService = directorService;
        this.directorMapperDto = directorMapperDto;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> addAuthor(@RequestBody DirectorDto directorDto) {
        final DirectorDto dto = directorMapperDto
                .entityToDto(directorService.create(directorMapperDto.dtoToEntity(directorDto)));
        return dto != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    
}

