package com.godeltech.app.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Dmitry Chueshov 28.01.2021 2:53
 *
 */

@Data
public class FilmDto {
    
    private int id;
    private String name;
    private String genre;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private DirectorDto director;
    
    
}
