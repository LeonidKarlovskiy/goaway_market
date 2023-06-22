package com.example.picturegramm.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    User user;
    @Column(nullable = false, updatable = false, length = 50)
    private String header;
    @Column(nullable = false, updatable = false, length = 300)
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Item> itemList;


    @Column(nullable = false, updatable = false)
    private LocalDateTime created;


    @PrePersist
    protected void onCreate() {

        this.created = LocalDateTime.now();

    }
}