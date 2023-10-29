package com.example.restAPI.api.controllers;

import com.example.restAPI.api.entities.Book;
import com.example.restAPI.api.entities.dto.BookDto;
import com.example.restAPI.api.mappers.Mapper;
import com.example.restAPI.api.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private Mapper<Book, BookDto> bookMapper;

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto){
        Book book = bookMapper.MapFrom(bookDto);
        Boolean isExist = bookService.isExist(isbn);
        Book savedBook = bookService.saveBook(isbn ,book);
        BookDto savedBookDto = bookMapper.MapTo(savedBook);
        if(isExist){//update
            System.out.println("It Exists");
            return new ResponseEntity<>(savedBookDto, HttpStatus.OK);
        }
        else {//create
            return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/books")
    public Page<BookDto> readBooks(Pageable pageable){
        Page<Book> bookList = bookService.findAll(pageable);
        return bookList.map(bookMapper::MapTo);
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> readBook(@PathVariable("isbn") String isbn){
        Book book = bookService.readBook(isbn);
        return book != null ? new ResponseEntity<>(bookMapper.MapTo(book),HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path="/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn){
        bookService.delete(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
