package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class GenreEntity {

    @Id
    @Column(name = "id_genre")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long _id;

    @Column(name = "name")
    private String _name;

    @Column(name = "image")
    private String _imageUrl;
}
