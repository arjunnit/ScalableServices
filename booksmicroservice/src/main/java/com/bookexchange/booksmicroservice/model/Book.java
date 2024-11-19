package com.bookexchange.booksmicroservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
@Schema(description = "Details about a book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Title of the book", example = "The Great Gasby")
    @Column(nullable = false)
    private String title;

    @Schema(description = "Author of the book", example = "F. Scott Fitzgerald")
    @Column(nullable = false)
    private String author;

    @Schema(description = "Genre of the book", example = "Romance")
    @Column(nullable = false)
    private String genre;

    @Schema(description = "Owner Id")
    @NotNull(message = "Owner ID is required")
    @Column(name = "owner_id", nullable = false)
    private Long ownerid;

    // Getter and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }
}
