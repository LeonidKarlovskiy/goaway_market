package com.example.picturegramm.repository;

import com.example.picturegramm.domain.Post;
import com.example.picturegramm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


    public Post findPostByUser(User user);

}
