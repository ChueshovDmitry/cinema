package com.godeltech.app.repository;

import com.godeltech.app.entity.Director;
import com.godeltech.app.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author Dmitry Chueshov 26.01.2021 15:07
 * @project application
 */

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
    
    boolean deleteEntityById(Integer id);
    List<Film> findAll();
    List<Film> findAllByDirectorFirstName(String surname);
    List<Film>findFilmByReleaseDateBetween(Date start,Date end);
    boolean existsByDirectorFirstName(String surname);
}
