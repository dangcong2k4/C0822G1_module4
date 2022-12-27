package com.codegym.exercise.controller;

import com.codegym.exercise.model.Books;
import com.codegym.exercise.model.ReturnBook;
import com.codegym.exercise.service.IBookService;
import com.codegym.exercise.service.IReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/returnBook")
public class ReturnBookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IReturnBookService returnBookService;

    @GetMapping("/{id}/borrow")
    private String showFormBorrow(@ModelAttribute("books") Books books, Model model){
        model.addAttribute("books",bookService.findById(books.getId()));
        return "borrow";
    }

    @PostMapping("/borrow")
    private String borrowBook(@ModelAttribute("books") Books books, RedirectAttributes redirectAttributes){
        bookService.reduceTheNumber(1);
        bookService.increasingTheNumber(1);
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        ReturnBook returnBook = new ReturnBook(code,books);
        returnBookService.save(returnBook);
        redirectAttributes.addFlashAttribute("mess","mượn thành công");
        redirectAttributes.addFlashAttribute("mess1","mã mượn sách của bạn là: "+code);
        return "redirect:/book";
    }
}
