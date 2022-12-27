package com.codegym.exercise.controller;

import com.codegym.exercise.model.Books;
import com.codegym.exercise.model.ReturnBook;
import com.codegym.exercise.service.IBookService;
import com.codegym.exercise.service.IReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IReturnBookService returnBookService;

    @GetMapping("/book")
    public String showList(Model model){
        List<Books> booksList = bookService.findAll();
        model.addAttribute("booksList",booksList);
        return "list";
    }

}
