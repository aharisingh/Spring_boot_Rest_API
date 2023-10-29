package com.example.restAPI.api.services;

import com.example.restAPI.api.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    Author saveAuthor(Author author);

    List<Author> readAuthors();

    Author readAuthor(Long id);

    Boolean isExist(Long id);

    void delete(Long id);
}
