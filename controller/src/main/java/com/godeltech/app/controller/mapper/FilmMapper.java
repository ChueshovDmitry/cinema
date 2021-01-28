package com.godeltech.app.controller.mapper;
import com.godeltech.app.controller.dto.FilmDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Film;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Dmitry Chueshov 28.01.2021 13:46
 * @project application
 */

@Component
public class FilmMapper implements AbstractionMapDto<FilmDto, Film> {

    private ModelMapper modelMapper;
    
    @Autowired
    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    @Override
    public FilmDto entityToDto(Film model) {
        return modelMapper.map(model,FilmDto.class);
    }
    
    @Override
    public Film dtoToEntity(FilmDto dtoModel) {
        return modelMapper.map(dtoModel,Film.class);
    }
    
    @Override
    public List<FilmDto> convertEntityToDTOList(List<Film> list) {
        Type listType = new TypeToken<List<FilmDto>>() {}.getType();
        return modelMapper.map(list,listType);
    }
}
