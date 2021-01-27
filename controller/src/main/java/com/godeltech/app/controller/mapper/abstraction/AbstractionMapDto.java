package com.godeltech.app.controller.mapper.abstraction;

import java.util.List;

/**
 * @author Dmitry Chueshov 06.12.2020 13:15
 *
 */

public interface AbstractionMapDto<T,S> {
    
    T modelToDto(S model);
    
    S dtoToModel(T dtoModel);
    
    List<T> convertEntityToDTOList(List<S> list);
    
  
}
