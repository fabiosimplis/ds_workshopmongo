package br.com.fjunior.workshopmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fjunior.workshopmongo.models.dto.PostDTO;
import br.com.fjunior.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {
    
    @Autowired
    private PostService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        var body = service.findById(id);
        return ResponseEntity.ok().body(body);
    }
}