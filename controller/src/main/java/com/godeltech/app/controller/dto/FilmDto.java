package com.godeltech.app.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Dmitry Chueshov 28.01.2021 2:53
 * @project application
 */

@Data
public class FilmDto {
    
    private int id;
    private String name;
    private Date releaseDate;
    private String genre;
    private DirectorDto director;
}
