package com.example.demosample.service;

import com.example.demosample.domain.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);
    Author find(int id);
    List<Author> findAll();
}
