package com.godeltech.app.repository;

import com.godeltech.app.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

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
    
    boolean existsByDirectorLastName(String surname);
    
//    @Query(value = "from Film t where t.releaseDate BETWEEN :startDate AND :endDate")
//    public List<Film> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
    
    List<Film> findByDirectorLastNameAndReleaseDateBetween(String lastName, Date dateAfter, Date dateBefore);
    
    List<Film> findByReleaseDateBetween(Date dateAfter, Date dateBefore);
}
