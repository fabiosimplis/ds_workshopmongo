package br.com.fjunior.workshopmongo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fjunior.workshopmongo.models.dto.PostDTO;
import br.com.fjunior.workshopmongo.models.dto.UserDTO;
import br.com.fjunior.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        var body = service.findById(id);
        return ResponseEntity.ok().body(body);
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<PostDTO>> getPosts(@PathVariable String id) {
        var posts = service.getPosts(id);
        return ResponseEntity.ok(posts);
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
