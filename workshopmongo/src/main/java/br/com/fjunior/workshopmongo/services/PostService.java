package br.com.fjunior.workshopmongo.services;

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
        List<Post> list = repository.findByTitleContainingIgnoreCase(text);
        return list.stream().map(PostDTO::new).toList();
    }
}