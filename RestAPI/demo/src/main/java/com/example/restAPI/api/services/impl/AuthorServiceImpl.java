package com.example.restAPI.api.services.impl;

import com.example.restAPI.api.entities.Author;
import com.example.restAPI.api.repositories.AuthorRepository;
import com.example.restAPI.api.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository =  authorRepository;
    }
    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> readAuthors() {
        Iterable<Author>  authors = authorRepository.findAll();
        List<Author> authorList = new ArrayList<>();
        authors.forEach(authorList::add);
        return authorList;
    }

    @Override
    public Author readAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public Boolean isExist(Long id) {
      return authorRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
