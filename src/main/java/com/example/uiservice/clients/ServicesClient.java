package com.example.uiservice.clients;

import com.example.uiservice.models.Book;
import com.example.uiservice.models.Books;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
public interface ServicesClient {

    @GET
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Books getAllBooks();

    @POST
    @Path("/create")
    @Produces
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response createBook(Book book);

    @GET
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Book getBookById(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    @Produces
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response updateBook(@PathParam("id") Long id, Book book);

    @DELETE
    @Path("/{id}")
    @Produces
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    Response deleteBook(@PathParam("id") Long id);
}
