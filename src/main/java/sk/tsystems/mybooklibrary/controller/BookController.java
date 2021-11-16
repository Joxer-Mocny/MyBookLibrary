package sk.tsystems.mybooklibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.mybooklibrary.repository.BookProperties;
import sk.tsystems.mybooklibrary.repository.BookRepository;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    BookProperties bookProperties;

    @GetMapping(value = "/")
    public String index(){return  "Hello to" + bookProperties.getName() + " read some book";}

    @GetMapping("/books")
    public List<sk.tsystems.mybooklibrary.entities.Book> getBooks(){
        return bookRepository.getBooks();
    }


    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        bookRepository.createBook((sk.tsystems.mybooklibrary.entities.Book) book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookRepository.deleteBook(bookRepository.getBook(id));
    }

    @PutMapping("books/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book){
        bookRepository.updateBook(id, (sk.tsystems.mybooklibrary.entities.Book) book);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book book;
        try {
            book = bookRepository.getBook(id);
        }catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

}
