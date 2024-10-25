package br.com.fjunior.workshopmongo.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.fjunior.workshopmongo.models.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);
    @Query("{ $and: [ {'moment': {$gte: ?1}}, {'moment': {$lte: ?2}} , { $or: [{ 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String title, Instant startMoment, Instant endMoment);
    List<Post> findByTitleContainingIgnoreCase(String title);
}
