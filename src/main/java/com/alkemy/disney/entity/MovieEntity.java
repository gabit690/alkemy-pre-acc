package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class MovieEntity {

    @Id
    @Column(name = "id_movie")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long _id;

    @Column(name = "title")
    private String _title;

    @Column(name = "image")
    private String _imageUrl;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate _creationDate;

    @Column(name = "rating")
    private int _rate;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character")
    )
    private Set<CharacterEntity> _characters = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_genre", insertable = false, updatable = false)
    private GenreEntity _genre;

    @Column(name = "id_genre", nullable = false)
    private Long _genreId;
}
