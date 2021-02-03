package com.godeltech.app.service.impl;
import com.godeltech.app.entity.Director;
import com.godeltech.app.repository.DirectorRepository;
import com.godeltech.app.service.AbstractDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * @author Dmitry Chueshov 26.01.2021 16:49
 * @project application
 */


@Service
public class DirectorService implements AbstractDirectorService {
    
    private final DirectorRepository directorRepository;
    
    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }
    
    
    @Override
    @Transactional(rollbackFor = {Exception.class })
    public Director create(Director entity) throws Exception {
        if(entity != null){
            return directorRepository.save(entity);
        } else throw new Exception("Error in create method,error in transactions," +
                " entity is equals null");
    }
    
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Director update(Director entity) throws Exception {
        if (directorRepository.existsById(entity.getId())){
            return directorRepository.save(entity);
        } else throw new Exception("Exception in update transaction");
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List <Director> getAll(){
        return directorRepository.findAll();
    }
    
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean delete(Integer id) throws Exception {
        if(directorRepository.existsById(id)){
           return directorRepository.deleteEntityById(id);
        }else throw new Exception("Exception in delete transaction");
    }
    
}
