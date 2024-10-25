package br.com.fjunior.workshopmongo.models.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.fjunior.workshopmongo.models.embedded.Author;
import br.com.fjunior.workshopmongo.models.embedded.Comment;
import br.com.fjunior.workshopmongo.models.entities.Post;

public class PostDTO {
    
    private String id;
    private Instant moment;
    private String title;
    private String body;

    private Author author;

    private List<Comment> comments = new ArrayList<>();

    public PostDTO() {
    }

    public PostDTO(String id, Instant moment, String title, String body, Author author) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public PostDTO(Post entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.title = entity.getTitle();
        this.body = entity.getBody();
        this.author = entity.getAuthor();
        this.comments.addAll(entity.getComments());
    }

    public String getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    
}
