package com.mystartup.monolith.api;

import com.mystartup.monolith.api.dto.PostDTO;
import com.mystartup.monolith.services.model.Post;
import com.mystartup.monolith.services.model.User;
import com.mystartup.monolith.services.PostService;
import com.mystartup.monolith.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController()
@RequestMapping("/posts")
public final class PostController {

  // Variables

  private final UserService userService;
  private final PostService postService;

  // Constructor

  @Autowired
  public PostController(UserService userService, PostService postService) {
    this.userService = userService;
    this.postService = postService;
  }

  // API

  @GetMapping
  public List<Post> index() {
    return postService.all();
  }

  @GetMapping("/{title}")
  public ResponseEntity<Post> show(@PathVariable String title) {
    try {
      final Post post = postService.getBy(title);

      return new ResponseEntity<>(post, HttpStatus.CREATED);
    } catch (MissingResourceException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody PostDTO body) {
    final String lastName = body.lastName();

    try {
      final User user = userService.getBy(lastName);
      final String username = user.getFullName();
      final String title = body.title();
      final String content = body.content();
      postService.create(username, title, content);

      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (MissingResourceException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{title}")
  public void update(@PathVariable String title, @RequestBody String body) {
  }

  @DeleteMapping("/{title}")
  public void delete(@PathVariable String title) {
  }
}
