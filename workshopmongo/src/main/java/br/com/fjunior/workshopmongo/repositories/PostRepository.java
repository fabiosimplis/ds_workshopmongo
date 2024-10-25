package br.com.fjunior.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.fjunior.workshopmongo.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);
    List<Post> findByTitleContainingIgnoreCase(String title);
}
