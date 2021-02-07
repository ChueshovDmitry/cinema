package com.godeltech.app.service;

import com.godeltech.app.entity.Director;
import com.godeltech.app.service.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Dmitry Chueshov 03.02.2021 13:12
 * @project application
 */

public interface AbstractDirectorService {
    
    @Transactional(rollbackFor = {Exception.class })
    Director create(Director entity) throws ResourceNotFoundException;
    
    @Transactional(rollbackFor = {Exception.class})
    Director update(Director entity) throws ResourceNotFoundException;
    
    @Transactional(readOnly = true)
    List<Director> getAll() throws ResourceNotFoundException;
    
    @Transactional(rollbackFor = {Exception.class})
    boolean delete(Integer id) throws ResourceNotFoundException;
}
