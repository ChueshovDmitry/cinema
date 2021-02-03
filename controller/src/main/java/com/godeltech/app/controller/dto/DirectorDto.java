package com.godeltech.app.controller.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

/**
 * @author Dmitry Chueshov 16.11.2020 18:52
 *
 */

@Data
public class DirectorDto {
    
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private Date birthDate;
    
}
