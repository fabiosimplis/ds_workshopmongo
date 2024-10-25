package br.com.fjunior.workshopmongo.services;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fjunior.workshopmongo.models.dto.PostDTO;
import br.com.fjunior.workshopmongo.models.entities.Post;
import br.com.fjunior.workshopmongo.repositories.PostRepository;
import br.com.fjunior.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id) {
        Post post = getPostById(id);
        return new PostDTO(post);
    }

    private Post getPostById(String id) {
        Optional<Post> result = repository.findById(id);
        Post post = result.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return post;
    }

    public List<PostDTO> findByTitle(String text){
        // List<Post> list = repository.findByTitleContainingIgnoreCase(text);
        List<Post> list = repository.searchTitle(text);
        return list.stream().map(PostDTO::new).toList();
    }

    public List<PostDTO> fullSearch(String text, String start, String end){
        Instant startMoment = convertMoment(start, Instant.MIN);
        Instant endMoment = convertMoment(end, Instant.now());

        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        return list.stream().map(PostDTO::new).toList();
    }

    private Instant convertMoment(String instantTime, Instant alternative) {
        try {
            return Instant.parse(instantTime);
        } catch (DateTimeParseException e) {
            return alternative;
        }
    }
}