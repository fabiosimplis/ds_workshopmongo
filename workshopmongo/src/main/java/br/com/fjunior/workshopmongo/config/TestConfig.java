package br.com.fjunior.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fjunior.workshopmongo.models.entities.User;
import br.com.fjunior.workshopmongo.repositories.PostRepository;
import br.com.fjunior.workshopmongo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired PostRepository postRepository;

    @PostConstruct
    public void init() {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
