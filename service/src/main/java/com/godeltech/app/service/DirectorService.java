package com.godeltech.app.service;

import com.godeltech.app.service.entity.Director;
import com.godeltech.app.service.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmitry Chueshov 26.01.2021 16:49
 * @project application
 */

@Service
public class DirectorService implements BaseAbstractService<Director> {
    
    
    private final DirectorRepository directorRepository;
    
    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }
}
