package seminars.fourth.book;


import org.junit.jupiter.api.Test;
import seminars.fourth.hotel.BookingService;
import seminars.fourth.message.MessageService;
import seminars.fourth.message.NotificationService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void testFindBookById() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(book);
        Book result = bookService.findBookById("1");

        assertEquals(book, result);
    }

    @Test
    void testFindAllBooks() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

//        Map<String, Book> books = new HashMap<>();
//        books.put("1", new Book("1", "Book1", "Author1"));
//        books.put("2", new Book("2", "Book2", "Author2"));

        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);


        when(bookRepository.findAll()).thenReturn(books);

        //verify(bookRepository).findAll();
        assertNotNull(books);
        assertEquals(2, books.size());

    }
}