package com.example.restAPI.api.repositories;

import com.example.restAPI.api.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book,String>, PagingAndSortingRepository<Book,String> {
}
