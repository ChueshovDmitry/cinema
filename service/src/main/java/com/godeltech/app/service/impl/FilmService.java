package com.godeltech.app.service.impl;


import com.godeltech.app.entity.Film;
import com.godeltech.app.repository.FilmRepository;
import com.godeltech.app.service.AbstractFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Dmitry Chueshov 26.01.2021 17:06
 * @project application
 */

@Service
public class FilmService implements AbstractFilmService {
    
    private final FilmRepository filmRepository;
    
    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    
    @Override
    @Transactional(rollbackFor = {Exception.class })
    public Film create(Film entity) throws Exception {
        if(entity != null){
            return filmRepository.save(entity);
        } else throw new Exception("Error in create method,error in transactions," + " entity is equals null");
    }
    
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Film update(Film entity) throws Exception {
        if (filmRepository.existsById(entity.getId())){
            return filmRepository.save(entity);
        } else throw new Exception("Exception in update transaction");
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Film> getAll(){
        return filmRepository.findAll();
    }
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean delete(Integer id) throws Exception {
        if(filmRepository.existsById(id)){
            return filmRepository.deleteEntityById(id);
        }else throw new Exception("Exception in delete transaction");
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Film> getFilmByDirector(String surname){
            return filmRepository.findAllByDirectorFirstName(surname);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Film> getAllBetweenDates(Date start,Date end){
        return filmRepository.findByReleaseDateBetween(start,end);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Film> findByDirectorAndReleaseDateBetween(String lastName,Date start,Date end){
        return filmRepository.findByDirectorLastNameAndReleaseDateBetween(lastName,start,end);
    }
}
