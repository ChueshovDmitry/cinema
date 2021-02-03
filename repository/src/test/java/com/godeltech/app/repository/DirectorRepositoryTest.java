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
        
        Director director = new Director();
        director.setBirthDate(new Date(2020-12-1));
        director.setFirstName("Tom");
        director.setLastName("Cruse");

        Film film = new Film();
        film.setName("Lisa");
        film.setGenre("Horror");
        film.setReleaseDate(new Date(2020-12-1));
        film.setDirector(director);
        filmRepository.save(film);
        
    }
}