package com.example.cw2.controller;

import com.example.cw2.model.AkshayBook;
import com.example.cw2.service.AkshayBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class AkshayBookController {
    private final AkshayBookService bookService;

    public AkshayBookController(AkshayBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<AkshayBook> createBook(@RequestBody AkshayBook Book) {
        AkshayBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<AkshayBook>> getAllBooks() {
        List<AkshayBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public AkshayBook updateBookById(@PathVariable Long bookId,@RequestBody AkshayBook book){
        AkshayBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public AkshayBook getBookById(@PathVariable Long bookId) {
        AkshayBook book = bookService.getBookById(bookId);
        return book;
    }
}
