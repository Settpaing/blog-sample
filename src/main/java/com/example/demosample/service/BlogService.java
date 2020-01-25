package com.example.demosample.service;

import com.example.demosample.domain.Blog;

import java.util.List;

public interface BlogService {

    Blog create(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    void deleteById(int id);
    void update(int id, Blog blog);
}
