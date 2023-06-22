package com.example.picturegramm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@Entity
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String about;
    @ManyToOne()
    private Post post;
    @Lob
    private byte[] image;


    public Item() {

    }
}
