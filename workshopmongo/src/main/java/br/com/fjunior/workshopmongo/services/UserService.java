package br.com.fjunior.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fjunior.workshopmongo.models.dto.UserDTO;
import br.com.fjunior.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        var users = repository.findAll();
        System.out.println("SERVICE");
        System.out.println(users);
        return users.stream().map(UserDTO::new).toList();
    }
}