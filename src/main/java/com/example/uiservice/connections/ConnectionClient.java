package com.example.uiservice.connections;

import com.example.uiservice.clients.ServicesClient;
import com.example.uiservice.models.Book;

public class ConnectionClient {

    private final ServicesClient remote;

    public ConnectionClient() {
        Connection connection = new Connection();
        remote = connection.getConnectionProxy();
    }

    public Book getBookById(Long id) {
        try{
            return remote.getBookById(id);
        }
        catch (javax.ws.rs.NotFoundException exception) {
            System.out.println("Error - book not found");
            return null;
        }
    }

    public void createBook(Book book) {
        remote.createBook(book);
        System.out.println("Created book");
    }

    public Iterable<Book> getAllBooks() {
        try {
            return remote.getAllBooks();
        }
        catch (javax.ws.rs.NotFoundException exception) {
            System.out.println("No records available");
            return null;
        }
    }

    public void deleteBook(Long id) {
        remote.deleteBook(id);
        System.out.println("Deleted book");
    }

    public void updateBook(Long id, Book book) {
        remote.updateBook(id, book);
        System.out.println("Edited book");
    }
}
