package br.com.fjunior.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fjunior.workshopmongo.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    
}
