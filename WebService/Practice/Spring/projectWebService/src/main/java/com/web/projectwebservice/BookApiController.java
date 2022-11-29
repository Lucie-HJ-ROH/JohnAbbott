package com.web.projectwebservice;

import com.web.projectwebservice.dto.Book;
import com.web.projectwebservice.exceptions.ServiceExeption;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bookservice")
public interface BookApiController {

    @Path("/books")
    @GET
    List<Book> getBooks();


    @Path("/books/{id}")
    @GET
    Book getBook(@PathParam("id") Long id);

    @Path("/books")
    @POST
    Response addBook(Book book);


    @Path("/books")
    @PUT
    Response updateBook(Book books) throws ServiceExeption;

    @Path("/books/{id}")
    @DELETE
    Response deleteBook(@PathParam("id") Long id) throws ServiceExeption;

}
