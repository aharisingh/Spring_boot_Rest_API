package com.example.restAPI.api.mappers.impl;

import com.example.restAPI.api.entities.Book;
import com.example.restAPI.api.entities.dto.BookDto;
import com.example.restAPI.api.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BookMapperImpl implements Mapper<Book, BookDto> {

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BookDto MapTo(Book book) {
        return modelMapper.map(book,BookDto.class);
    }

    @Override
    public Book MapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto,Book.class);
    }
}
