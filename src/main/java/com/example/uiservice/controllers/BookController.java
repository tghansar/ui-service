package com.example.uiservice.controllers;

import com.example.uiservice.connections.ConnectionClient;
import com.example.uiservice.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final ConnectionClient connectionClient;

    public BookController() {
        // initiate connection client
        connectionClient = new ConnectionClient();
    }

    // -- index page --
    @RequestMapping("/")
    public String showHome(Model model){
        model.addAttribute("books", connectionClient.getAllBooks());
        return "index"; //html file
    }

    // -- form navigation --
    @GetMapping("/add-form")
    public String getAddForm(Model model){
        model.addAttribute("book", new Book());
        return "add-new-book";
    }

    @GetMapping("/delete-form")
    public String getDeleteForm(Model model){
        model.addAttribute("book", new Book());
        return "delete-existing-book";
    }

    @GetMapping("/edit-form")
    public String getEditForm(Model model){
        model.addAttribute("book", new Book());
        return "edit-existing-book";
    }

    @GetMapping("/list-form")
    public String getListForm(Model model){
        model.addAttribute("books", connectionClient.getAllBooks()); // list of books
        return "list-all-books";
    }

    // -- form submissions --
    @RequestMapping("/add-form")
    public String submitAdd(@ModelAttribute("book") Book book, Model model){
        model.addAttribute("book", book);
        connectionClient.createBook(book);
        return "add-new-book";
    }

    @RequestMapping("/edit-form")
    public String submitEdit(@ModelAttribute("book") Book book, Model model){
        model.addAttribute("book", book);
        connectionClient.updateBook(book.getId(), book);
        return "edit-existing-book";
    }

    @RequestMapping("/delete-form")
    public String submitDelete(@ModelAttribute("book") Book book, Model model){
        model.addAttribute("book", book);
        connectionClient.deleteBook(book.getId());
        return "delete-existing-book";
    }
}