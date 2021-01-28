package com.godeltech.app.controller.dto;
import lombok.Data;

import java.util.*;

/**
 * @author Dmitry Chueshov 16.11.2020 18:52
 * @project library
 */

@Data
public class DirectorDto {
    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private List <FilmDto> filmSet = new ArrayList<>();
}
