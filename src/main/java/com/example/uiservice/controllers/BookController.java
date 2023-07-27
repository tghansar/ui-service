package com.example.uiservice.controllers;

import com.example.uiservice.connections.ConnectionClient;
import com.example.uiservice.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.validation.Valid;

@Controller
public class BookController {
    private ServletContext servletContext;
    private ConnectionClient connectionClient;


    public BookController(ServletContext servletContext) {
        this.servletContext = servletContext;

        // initiate connection client
        connectionClient = new ConnectionClient();
    }

    @RequestMapping("/")
    public String showHome(Model model){
        model.addAttribute("books", connectionClient.getAllBooks()); //BOOKS
        return "index"; //html file
    }

    @GetMapping("/add")
    public String showAddForm(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        model.addAttribute("book", new Book()); //BOOK
        return "add-new-book"; //html file
    }

    @RequestMapping("/edit")
    public String showEditForm(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        model.addAttribute("book", new Book());
        return "edit-existing-book"; //html file
    }

    @RequestMapping("/delete")
    public String showDeleteForm(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        model.addAttribute("book", book);
        connectionClient.deleteBook(book.getId());
        return "delete-existing-book"; //html file
    }

    @RequestMapping("/list")
    public String showListForm(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        model.addAttribute("book", new Book());
        return "list-all-books"; //html file
    }

    // Navigation
    @GetMapping("/add-form")
    public String getAddForm(){
        return "add-new-book.html";
    }

    @GetMapping("/delete-form")
    public String getDeleteForm(){
        return "delete-existing-book.html";
    }

    @GetMapping("/edit-form")
    public String getEditForm(){
        return "edit-existing-book.html";
    }

    @GetMapping("/list-form")
    public String getListForm(){
        return "list-all-books.html";
    }
}