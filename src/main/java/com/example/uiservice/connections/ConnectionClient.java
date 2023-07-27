package com.example.uiservice.connections;

import com.example.uiservice.models.Book;
import com.example.uiservice.models.Books;

public class ConnectionClient {

    private final Connection connection;

    public ConnectionClient() {
        this.connection = new Connection();
    }

    public Book getBookById(Long id) {
        Book book = null;

        try{
            book = connection.getConnectionProxy().getBookById(id);
            return book;
        }
        catch (javax.ws.rs.NotFoundException exception) {
            System.out.println("Error - book not found");
            return null;
        }
    }

    public void createBook(Book book) {
        connection.getConnectionProxy().createBook(book);
    }

    public Iterable<Book> getAllBooks() {
        Books books = null;

        try {
            books = connection.getConnectionProxy().getAllBooks();
            return books.getBooks();
        }
        catch (javax.ws.rs.NotFoundException exception) {
            System.out.println("No records available");
            return null;
        }
    }

    public void deleteBook(Long id) {
        connection.getConnectionProxy().deleteBook(id);
        System.out.println("Deleted book");
    }
}
