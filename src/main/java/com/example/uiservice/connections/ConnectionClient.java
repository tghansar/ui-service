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
            exception.printStackTrace();
            return null;
        }
    }

    public void createBook(Book book) {
        remote.createBook(book);
    }

    public Iterable<Book> getAllBooks() {
        try {
            return remote.getAllBooks();
        }
        catch (javax.ws.rs.NotFoundException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void deleteBook(Long id) {
        remote.deleteBook(id);
    }

    public void updateBook(Long id, Book book) {
        remote.updateBook(id, book);
    }
}
