package com.web.projectwebservice;


import com.web.projectwebservice.dto.Book;
import com.web.projectwebservice.exceptions.ServiceExeption;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class BookApiControllerImpl implements BookApiController {

    Map<Long, Book> books = new HashMap<>();
    long currentId = 10000;

    public BookApiControllerImpl() {
        init();
    }

    void init() {
        Book book = new Book();
        List<String> BookTitle = new ArrayList<>();

        BookTitle.add("HarryPotter01");
        BookTitle.add("HarryPotter02");
        BookTitle.add("HarryPotter03");
        BookTitle.add("HarryPotter04");
        BookTitle.add("HarryPotter05");
        BookTitle.add("The Midnight Library");
        BookTitle.add("PACHINKO");
        BookTitle.add("When you Trap a Tiger");
        BookTitle.add("Diary of Whimpy Kids 01");
        BookTitle.add("Diary of Whimpy Kids 02");
        BookTitle.add("Diary of Whimpy Kids 03");
        BookTitle.add("Diary of Whimpy Kids 04");
        BookTitle.add("Diary of Whimpy Kids 05");
        BookTitle.add("Diary of Whimpy Kids 06");

        for (int i = 0; i <BookTitle.size() ; i++) {
            book.setId(currentId++);
            book.setTitle(BookTitle.get(i));
            books.put(book.getId(), book);
        }

    }


    @Override
    public List<Book> getBooks() {
        Collection<Book> bookInfo = books.values();
        List<Book> bookResponse = new ArrayList<>(bookInfo);
        return bookResponse;
    }

    @Override
    public Book getBook(Long id) {
        return books.get(id);
    }

    @Override
    public Response addBook(Book book) {
        book.setId(++currentId);
        books.put(book.getId(), book);
        return Response.ok(book).build();
    }

    @Override
    public Response updateBook(Book book) throws ServiceExeption {
        Book currentBook = books.get(book.getId());
        Response response;


        if (currentBook != null) {
            books.put(book.getId(), book);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
            throw new ServiceExeption("There is no book with id :  " + book.getId());
        }

        return response;
    }

    @Override
    public Response deleteBook(Long id) throws ServiceExeption {
        Book book = books.get(id);
        Response response;
        if (book != null) {
            books.remove(id);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
            throw new ServiceExeption("There is no book with id :  " + id);
        }

        return response;
    }
}
