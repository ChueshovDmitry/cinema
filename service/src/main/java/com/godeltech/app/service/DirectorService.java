package com.godeltech.app.service;

import com.godeltech.app.entity.Director;
import com.godeltech.app.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * @author Dmitry Chueshov 26.01.2021 16:49
 * @project application
 */


@Service
public class DirectorService  {
    
    private final DirectorRepository directorRepository;
    
    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }
    
    
    @Transactional(rollbackFor = {Exception.class })
    public Director create(Director entity){
        try{
            return directorRepository.save(entity);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
    @Transactional(rollbackFor = {Exception.class})
    public Director update(Director entity) throws Exception {
        if (directorRepository.existsById(entity.getId())){
            return directorRepository.save(entity);
        } else throw new Exception(entity.getFirstName() + entity.getLastName() +
                "Exception in update transaction");
    }
    
    
    @Transactional(readOnly = true)
    public List <Director> getAll(){
        return directorRepository.findAll();
    }
    
    
    @Transactional(rollbackFor = {Exception.class})
    public boolean delete (Director entity){
        if(directorRepository.existsById(entity.getId())){
           return directorRepository.deleteEntityById(entity.getId());
        }else return false;
    }
    
}
