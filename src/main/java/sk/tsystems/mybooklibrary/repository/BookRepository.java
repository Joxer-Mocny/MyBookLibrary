package sk.tsystems.mybooklibrary.repository;

import sk.tsystems.mybooklibrary.entities.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();
    Book getBook(int id);
    void createBook(Book book);
    void deleteBook(Book book);
    void updateBook(int id, Book book);

}
