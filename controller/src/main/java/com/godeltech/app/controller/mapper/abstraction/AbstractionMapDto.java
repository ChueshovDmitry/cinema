package com.godeltech.app.controller.mapper.abstraction;

import java.util.List;

/**
 * @author Dmitry Chueshov 06.12.2020 13:15
 *
 */

public interface AbstractionMapDto<T,S> {
    
    T entityToDto(S model);
    
    S dtoToEntity(T dtoModel);
    
    List<T> convertEntityToDTOList(List<S> list);
    
  
}
