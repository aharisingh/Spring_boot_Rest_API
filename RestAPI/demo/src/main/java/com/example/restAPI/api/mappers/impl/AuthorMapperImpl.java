package com.example.restAPI.api.mappers.impl;

import com.example.restAPI.api.entities.Author;
import com.example.restAPI.api.entities.dto.AuthorDto;
import com.example.restAPI.api.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<Author, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public AuthorDto MapTo(Author author) {
        return modelMapper.map(author ,  AuthorDto.class);
    }

    @Override
    public Author MapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto,Author.class);
    }
}
