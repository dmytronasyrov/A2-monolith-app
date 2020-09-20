package com.mystartup.monolith.services.impl;

import com.mystartup.monolith.model.Post;
import com.mystartup.monolith.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;

@Service
public final class PostServiceImpl implements PostService {

  // Public

  public List<Post> all() {
    return List.of(
      new Post("BlogPost1", "Post content 1", "Ivan Petrov"),
      new Post("BlogPost2", "Post content 2", "Petr Ivanov")
    );
  }

  public Post getBy(String title) {
    if (title.equals("BlogPost1"))
      return new Post("BlogPost1", "Post content 1", "Ivan Petrov");
    else
      throw new MissingResourceException("Post not found", "Post", title);
  }

  public Post create(String username, String title, String content) {
    return Post.builder()
      .title(title)
      .content(content)
      .username(username)
      .build();
  }

  public void update(String title, String content) {
  }

  public void delete(String title) {
  }
}
