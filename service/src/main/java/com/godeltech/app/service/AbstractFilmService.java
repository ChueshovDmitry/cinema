package com.godeltech.app.service;

import com.godeltech.app.entity.Film;
import com.godeltech.app.service.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Dmitry Chueshov 03.02.2021 13:13
 * @project application
 */

public interface AbstractFilmService {
    
    @Transactional(rollbackFor = {Exception.class })
    Film create(Film entity) throws ResourceNotFoundException;
    
    @Transactional(rollbackFor = {Exception.class})
    Film update(Film entity) throws ResourceNotFoundException;
    
    @Transactional(rollbackFor = {Exception.class})
    boolean delete(Integer id) throws ResourceNotFoundException;
    
    @Transactional(readOnly = true)
    List<Film> getAll();
    
    @Transactional(readOnly = true)
    List<Film> getFilmByDirector(String surname);
    
    @Transactional(readOnly = true)
    List<Film> getAllBetweenDates(Date start,Date end);
    
    @Transactional(readOnly = true)
    List<Film> findByDirectorAndReleaseDateBetween(String lastName,Date start,Date end);
}
