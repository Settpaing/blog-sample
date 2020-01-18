package com.example.demosample.controller;

import com.example.demosample.domain.Author;
import com.example.demosample.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")  // first phase
    public String create(Model model){
        model.addAttribute("author",new Author());
        return "admin/authorForm";
    }

    @PostMapping("/author") // second phase
    public String process(@Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "admin/authorForm";
        }
        authorService.create(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors")
    public String showAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "admin/authors";
    }

    @GetMapping("/layout")
    public String testLayout(){
        return "layout/adminLayout";
    }
}
