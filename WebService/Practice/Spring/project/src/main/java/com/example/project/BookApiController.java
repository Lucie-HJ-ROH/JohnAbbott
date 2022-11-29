package com.example.project;

import com.example.project.dto.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bookservice")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
public interface BookApiController {

    @Path("/books")
    @GET
    List<Book> getBooks();


    @Path("/books/id/{id}")
    @GET
    Book getBook(@PathParam("id") Long id);

    @Path("/books/title/{title}")
    @GET
    List<Book> getBook(@PathParam("title") Book book);

    @Path("/books")
    @POST
    Response addBook(Book book);


    @Path("/books")
    @PUT
    Response updateBook(Book books);

    @Path("/books/{id}")
    @DELETE
    Response deleteBook(@PathParam("id") Long id);

}
