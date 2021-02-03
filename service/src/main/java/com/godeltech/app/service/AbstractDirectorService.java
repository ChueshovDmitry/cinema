package com.godeltech.app.service;

import com.godeltech.app.entity.Director;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Dmitry Chueshov 03.02.2021 13:12
 * @project application
 */

public interface AbstractDirectorService {
    
    @Transactional(rollbackFor = {Exception.class })
    Director create(Director entity) throws Exception;
    
    @Transactional(rollbackFor = {Exception.class})
    Director update(Director entity) throws Exception;
    
    @Transactional(readOnly = true)
    List<Director> getAll();
    
    @Transactional(rollbackFor = {Exception.class})
    boolean delete(Integer id) throws Exception;
}
