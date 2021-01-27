package com.godeltech.app.repository;

import com.godeltech.app.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitry Chueshov 26.01.2021 15:07
 * @project application
 */

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
    

}