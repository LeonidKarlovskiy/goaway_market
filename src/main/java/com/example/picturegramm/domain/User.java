package com.example.picturegramm.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity()
@Table(name = "person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] avatar;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Post> postList;






    @PrePersist
    protected void onCreate(){this.created = LocalDateTime.now();}



}
