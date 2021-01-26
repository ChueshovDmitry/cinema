package com.godeltech.app.service;

import com.godeltech.app.service.entity.Film;
import com.godeltech.app.service.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmitry Chueshov 26.01.2021 17:06
 * @project application
 */

@Service
public class FilmService implements BaseAbstractService<Film> {
    
    private final FilmRepository filmRepository;
    
    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}
