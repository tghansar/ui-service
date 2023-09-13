package com.example.uiservice;

import com.example.uiservice.connections.ConnectionClient;
import com.example.uiservice.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UiServiceApplicationTests {

    @Test
    void contextLoads() {
        ConnectionClient testClient = new ConnectionClient();

        System.out.println("\nList current books:");
        for (Book book : testClient.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\nShow book at index 2:");
        System.out.println(testClient.getBookById(2L));


        System.out.println("\nDeleting book at index 3");
        testClient.deleteBook(3L);

        Book newBook = new Book("1984",
                "59843805-54-12",
                "1949",
                "250",
                "Ebook");

        System.out.println("\nAdding new " + newBook);
        testClient.createBook(newBook);

        System.out.println("\nTesting List current books:");
        for (Book book : testClient.getAllBooks()) {
            System.out.println(book);
        }

        testClient.updateBook(1L, new Book("#", "#", "#", "#", "#"));
    }

}
