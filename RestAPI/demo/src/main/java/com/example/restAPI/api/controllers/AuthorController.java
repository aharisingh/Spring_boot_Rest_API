package com.example.restAPI.api.controllers;
import com.example.restAPI.api.entities.Author;
import com.example.restAPI.api.entities.dto.AuthorDto;
import com.example.restAPI.api.mappers.Mapper;
import com.example.restAPI.api.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private AuthorService authorService;

    private Mapper<Author,AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<Author,AuthorDto> authorMapper){

        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorMapper.MapFrom(authorDto);
        Author savedAuthor = authorService.saveAuthor(author);
        return authorMapper.MapTo(savedAuthor);
    }

    @GetMapping (path = "/authors")
    public List<AuthorDto> readAuthors(){
        List<Author> authors = authorService.readAuthors();
        return authors.stream().map(authorMapper::MapTo).collect(Collectors.toList());
    }

    @GetMapping (path = "/authors/{id}")
    public ResponseEntity<AuthorDto> readAuthor(@PathVariable("id") Long id){
        Author author = authorService.readAuthor(id);
        return author != null ?new ResponseEntity<>(authorMapper.MapTo(author) , HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable("id") Long id , @RequestBody AuthorDto authorDto){
        if(!authorService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorDto.setId(id);
        Author author = authorMapper.MapFrom(authorDto);
        Author savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(authorMapper.MapTo(savedAuthor),HttpStatus.OK);
    }

    @DeleteMapping(path = "/authors/{id}")
    public ResponseEntity deleteAuthor(@PathVariable ("id") Long id){
        authorService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
