package com.example.restAPI.api.services.impl;

import com.example.restAPI.api.entities.Book;
import com.example.restAPI.api.repositories.BookRepository;
import com.example.restAPI.api.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public Book saveBook(String isbn , Book book) {
        book.setIsbn(isbn);
       return bookRepository.save(book);
    }

    @Override
    public List<Book> readBooks() {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        books.forEach(bookList::add);
        return bookList;
    }

    @Override
    public Book readBook(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        return book.orElse(null);
    }

    @Override
    public Boolean isExist(String isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
