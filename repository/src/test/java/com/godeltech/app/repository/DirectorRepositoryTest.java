package com.godeltech.app.repository;

import com.godeltech.app.entity.Director;
import com.godeltech.app.entity.Film;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Chueshov 28.01.2021 17:25
 * @project application
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class DirectorRepositoryTest {
    
    @Autowired
    private FilmRepository filmRepository;
    
    
    @Test
    @Rollback(false)
    void saveEntity(){
        
        Director director = Director.builder()
                .birthDate(LocalDate.of(2020,12,1))
                .firstName("Tom")
                .lastName("Cruse").build();
        
        Film film = Film.builder().name("Lisa")
                .genre("Horror")
                .releaseDate(LocalDate.of(2020,1,1))
                .director(director)
                .build();
        
        filmRepository.save(film);
        
    }
}