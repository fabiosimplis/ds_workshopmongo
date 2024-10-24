package br.com.fjunior.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fjunior.workshopmongo.models.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
    
}
