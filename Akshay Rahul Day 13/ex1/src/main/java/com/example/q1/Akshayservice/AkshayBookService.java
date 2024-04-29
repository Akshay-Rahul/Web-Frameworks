package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.AkshayAuthor;
import com.example.q1.model.AkshayBook;
import com.example.q1.repository.AkshayAuthorRepository;
import com.example.q1.repository.AkshayBookRepository;

@Service
public class AkshayBookService {
    @Autowired
    private AkshayBookRepository bookRepository;
@Autowired
private AkshayAuthorRepository authorRepository;
    public AkshayBook saveBook(Long authorId, AkshayBook book) {
        AkshayAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public AkshayBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

