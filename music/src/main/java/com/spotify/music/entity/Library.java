package com.spotify.music.entity;

import java.util.HashSet;

import java.util.Set;

 

// import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.ManyToOne;

import lombok.Data;

 

@Entity

@Data

public class Library {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

 

    // @ManyToMany

    // @JoinTable(

    //     name = "library_song_user", // The name of the junction table

    //     joinColumns = @JoinColumn(name = "library_id"), // Column in this entity

    //     inverseJoinColumns = {

    //         @JoinColumn(name = "song_id"), // Column in the related entity (Song)

    //         @JoinColumn(name = "user_id")  // Column in the related entity (User)

    //     }

    // )

    // private Set<Song> songs = new HashSet<>();

   

    @ManyToOne

    @JoinColumn(name = "user_id") // Column in the library table that references the User entity

    private User user;

 

    // Many-to-one relationship with Song entity

    @ManyToOne

    @JoinColumn(name = "song_id") // Column in the library table that references the Song entity

    private Song song;

   

 

 

   

}

 
