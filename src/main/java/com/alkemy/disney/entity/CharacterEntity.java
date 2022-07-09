package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @Column(name = "id_character")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long _id;

    @Column(name = "name")
    private String _name;

    @Column(name = "image")
    private String _imageUrl;

    @Column(name = "age")
    private int _age;

    @Column(name = "weight")
    private double _weight;

    @Column(name = "story")
    private String _story;

    @ManyToMany(mappedBy = "_characters", cascade = CascadeType.PERSIST)
    private Set<MovieEntity> _movies =  new HashSet<>();
}
