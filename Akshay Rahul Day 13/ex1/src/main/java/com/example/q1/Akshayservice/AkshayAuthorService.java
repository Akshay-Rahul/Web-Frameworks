package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.AkshayAuthor;
import com.example.q1.repository.AkshayAuthorRepository;

@Service
public class AkshayAuthorService {
    @Autowired
    private AkshayAuthorRepository authorRepository;

    public AkshayAuthor saveAuthor(AkshayAuthor author) {
        return authorRepository.save(author);
    }

    public AkshayAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<AkshayAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AkshayAuthor updateAuthor(Long id, AkshayAuthor author) {
        AkshayAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
