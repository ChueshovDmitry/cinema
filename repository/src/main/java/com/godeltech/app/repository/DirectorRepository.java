package com.godeltech.app.repository;

import com.godeltech.app.entity.Director;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitry Chueshov 26.01.2021 15:06
 * @project application
 */

@Repository
public interface DirectorRepository extends PagingAndSortingRepository<Director,Integer> {

    boolean deleteEntityById(Integer id);
    List <Director> findAll();
    
    
    
}
