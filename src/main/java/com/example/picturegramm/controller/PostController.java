package com.example.picturegramm.controller;


import com.example.picturegramm.domain.Item;
import com.example.picturegramm.domain.Post;
import com.example.picturegramm.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {
    final  PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public String postIndex(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @GetMapping("/createPost")
    public String getCreatePostForm(@ModelAttribute Post post, @ModelAttribute Item item) {
        post.setItemList(new ArrayList<>());

        return "createPost";
    }


    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Post post, @ModelAttribute List<Item> itemList) {
        post.setItemList(itemList);
        postService.save(post);
        return "redirect:/posts";
    }

}
