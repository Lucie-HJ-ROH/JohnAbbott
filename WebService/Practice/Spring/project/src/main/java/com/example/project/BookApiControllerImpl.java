package com.example.project;


import com.example.project.dto.Book;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class BookApiControllerImpl implements BookApiController {

    Map<Long, Book> books = new HashMap<>();
    long currentId = 1000;

    public BookApiControllerImpl() {
        init();
    }

    void init() {


        List<Book> book = new ArrayList<>();
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

        for (int i = 0; i < BookTitle.size(); i++) {
            book.add(new Book());
            book.get(i).setId(++currentId);
            book.get(i).setTitle(BookTitle.get(i));
            ;
            books.put(book.get(i).getId(), book.get(i));
        }
    }

    @Override
    public List<Book> getBooks() {
        List<Book> bookList = books.values().stream().collect(Collectors.toCollection(ArrayList::new));

        return bookList;
    }

    @Override
    public Book getBook(Long id) {

        return books.get(id);
    }

    @Override
    public List<Book> getBook(Book book) {

        List<Book> bookList = new ArrayList<>();
        List<Long> keyList = new ArrayList<>();
        Set<Map.Entry<Long, Book>> entries = books.entrySet();

        for (Map.Entry<Long, Book> entry : entries) {
            if (entry.getValue().getTitle().toLowerCase().contains(book.getTitle().toLowerCase())) {
                keyList.add(entry.getKey());
            }
        }
        for (Long list : keyList) {
            bookList.add(books.get(list));
        }

        return bookList;
    }

    @Override
    public Response addBook(Book book) {
        book.setId(++currentId);
        books.put(book.getId(), book);
        return Response.ok(book).build();
    }


    @Override
    public Response updateBook(Book book) {
        Book currentBook = books.get(book.getId());
        Response response;


        if (currentBook != null) {
            books.put(book.getId(), book);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }

        return response;
    }

    @Override
    public Response deleteBook(Long id) {
        Book book = books.get(id);
        Response response;
        if (book != null) {
            books.remove(id);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }
        return response;

    }
}
