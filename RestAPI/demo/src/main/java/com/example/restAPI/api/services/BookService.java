package com.example.restAPI.api.services;

import com.example.restAPI.api.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book saveBook(String isbn ,Book book);

    List<Book> readBooks();

    Book readBook(String isbn);

    Boolean isExist(String isbn);

    void delete(String isbn);

    Page<Book> findAll(Pageable pageable);
}
