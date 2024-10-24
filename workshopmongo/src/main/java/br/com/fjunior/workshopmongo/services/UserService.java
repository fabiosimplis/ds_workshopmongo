package br.com.fjunior.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fjunior.workshopmongo.models.dto.UserDTO;
import br.com.fjunior.workshopmongo.models.entities.User;
import br.com.fjunior.workshopmongo.repositories.UserRepository;
import br.com.fjunior.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        var users = repository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id) {
        Optional<User> result = repository.findById(id);
        User user = result.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return new UserDTO(user);
    }
}