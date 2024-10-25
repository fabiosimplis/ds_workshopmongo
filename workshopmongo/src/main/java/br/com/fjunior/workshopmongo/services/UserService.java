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
        User user = getUserById(id);
        return new UserDTO(user);
    }

    public UserDTO insert(UserDTO dto) {
        User entity = new User();
        dtoToUserEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public UserDTO update(String id, UserDTO dto) {
        User entity = getUserById(id);
        dtoToUserEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(String id) {
        getUserById(id);
        repository.deleteById(id);
    }

    private User getUserById(String id) {
        Optional<User> result = repository.findById(id);
        User user = result.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return user;
    }

    private void dtoToUserEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}