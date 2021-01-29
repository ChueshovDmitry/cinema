package com.godeltech.app.controller.rest;

import com.godeltech.app.controller.dto.DirectorDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Director;
import com.godeltech.app.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<?> postDirector(@RequestBody DirectorDto directorDto) {
        final DirectorDto dto = directorMapperDto
                .entityToDto(directorService.create(directorMapperDto.dtoToEntity(directorDto)));
        return dto != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<?>> getAllDirector() {
        final List<DirectorDto> directorDtoList = directorMapperDto.convertEntityToDTOList(directorService.getAll());
        return directorDtoList != null && !directorDtoList.isEmpty() ? new ResponseEntity<>(directorDtoList,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable("id") Integer id, @RequestBody DirectorDto directorDto) throws Exception {
        final DirectorDto dto = directorMapperDto.entityToDto(directorService.update(directorMapperDto.dtoToEntity(directorDto)));
        return dto != null ? new ResponseEntity<>(dto,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable(name = "id") Integer id) {
        final boolean deleted = directorService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
    
}

