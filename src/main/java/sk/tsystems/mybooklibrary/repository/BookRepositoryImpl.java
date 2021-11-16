package sk.tsystems.mybooklibrary.repository;

import org.springframework.stereotype.Repository;
import sk.tsystems.mybooklibrary.controller.BookController;
import sk.tsystems.mybooklibrary.entities.Book;

import java.util.LinkedList;
import java.util.List;
@Repository
public class BookRepositoryImpl implements BookRepository {

    private final List<Book> books = new LinkedList<>();

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBook(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .limit(1)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(Book book) {
        books.remove(book);
    }

    @Override
    public void updateBook(int id, Book book) {
        books.stream()
                .filter(b -> b.getId() == book.getId())
                .limit(1)
                .forEach(b -> {
                    b.setId(book.getId());
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setDate(book.getDate());
                });
    }

}
