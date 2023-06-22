package com.example.picturegramm.controller;


import com.example.picturegramm.domain.Post;
import com.example.picturegramm.domain.User;
import com.example.picturegramm.service.PostService;
import com.example.picturegramm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping()
public class UserController {
    final UserService userService;
    final PostService postService;


    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;

        this.postService = postService;
    }

    @GetMapping()
    public String indexOfAllUsers(Model model) {
        List<User> users = userService.listOfAllUsers();

        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/createUser")
    public String formForCreatingUser(@ModelAttribute User user){
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:";
    }

    @GetMapping("/{id}")
    public String userPage(@PathVariable ("id") Long id, Model model, @ModelAttribute Post post){
        User user = userService.findUserById(id);
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("userId", user.getId());
        return "userPage";
    }

    @GetMapping("{id}/edit")
    public String formForEditUser(@PathVariable ("id") Long id, Model model){
        model.addAttribute("person", userService.findUserById(id));
        return "editUser";
    }

    @PostMapping("createPost")
    public String createPost(@ModelAttribute Post post,@RequestParam("userId") Long userId){
        User user = userService.findUserById(userId);
        post.setUser(user);
        postService.save(post);
        return "redirect:/";
    }


    @GetMapping("/index")
    public String allPosts(Model model){
        model.addAttribute("posts", postService.getAllPosts());

        return "posts";
    }




    @ModelAttribute
    public void Hello(Model model) {
        model.addAttribute("usersList", "List of users");
        model.addAttribute("create", "Create user here");
    }


}
