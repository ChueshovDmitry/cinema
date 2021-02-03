package com.godeltech.app.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Dmitry Chueshov 02.02.2021 14:14
 * @project application
 */

@Component
@Data
public class DateAndLastNameSearcherDto {
    
    private String lastName;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private Date startDate;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
    private Date endDate;

}
