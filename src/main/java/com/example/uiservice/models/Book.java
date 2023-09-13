package com.example.uiservice.models;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "book")
public class Book implements Serializable {

    public Book() {
    }

    public Book(String name, String isbn, String publishDate, String price, String bookType) {
        this.name = name;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.price = price;
        this.bookType = bookType;
    }

    @XmlAttribute(name = "id")
    private Long id;

    @XmlElement(name = "book_name")
    private String name;

    @XmlElement(name = "book_isbn")
    private String isbn;

    @XmlElement(name = "book_publish_dt")
    private String publishDate;

    @XmlElement(name = "book_price")
    private String price;

    @XmlElement(name = "book_type")
    private String bookType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // being used by Thymeleaf
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", price='" + price + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}