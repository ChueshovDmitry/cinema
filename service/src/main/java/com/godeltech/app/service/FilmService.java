package com.godeltech.app.service;


import com.godeltech.app.entity.Director;
import com.godeltech.app.entity.Film;
import com.godeltech.app.repository.FilmRepository;
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
public class FilmService {
    
    private final FilmRepository filmRepository;
    
    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    
    @Transactional(rollbackFor = {Exception.class })
    public Film create(Film entity){
        try{
            return filmRepository.save(entity);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public Film update(Film entity) throws Exception {
        if (filmRepository.existsById(entity.getId())){
            return filmRepository.save(entity);
        } else throw new Exception(entity.getGenre()
                + entity.getName()
                + entity.getDirector()
                + "Exception in update transaction");
    }
    
    
    @Transactional(readOnly = true)
    public List<Film> getAll(){
        return filmRepository.findAll();
    }
    
    
    @Transactional(rollbackFor = {Exception.class})
    public boolean delete(Integer id){
        if(filmRepository.existsById(id)){
            return filmRepository.deleteEntityById(id);
        }else return false;
    }
    
    @Transactional(readOnly = true)
    public List<Film> getFilmByDirector(String surname){
        if(filmRepository.existsByDirectorFirstName(surname)){
            return filmRepository.findAllByDirectorFirstName(surname);
        }else return null;
    }
    
    @Transactional(readOnly = true)
    public List<Film> getAllBetweenDate(Date start,Date end){
        return filmRepository.findFilmByReleaseDateBetween(start,end);
    }
    
}
