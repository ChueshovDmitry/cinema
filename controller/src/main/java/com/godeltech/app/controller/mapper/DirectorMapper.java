package com.godeltech.app.controller.mapper;
import com.godeltech.app.controller.dto.DirectorDto;
import com.godeltech.app.controller.mapper.abstraction.AbstractionMapDto;
import com.godeltech.app.entity.Director;
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
public class DirectorMapper implements AbstractionMapDto<DirectorDto, Director> {

    private ModelMapper modelMapper;
    
    @Autowired
    public DirectorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    @Override
    public DirectorDto entityToDto(Director model) {
        return modelMapper.map(model,DirectorDto.class);
    }
    
    @Override
    public Director dtoToEntity(DirectorDto dtoModel) {
        return modelMapper.map(dtoModel,Director.class);
    }
    
    @Override
    public List<DirectorDto> convertEntityToDTOList(List<Director> list) {
        Type listType = new TypeToken<List<DirectorDto>>() {}.getType();
        return modelMapper.map(list,listType);
    }
}
