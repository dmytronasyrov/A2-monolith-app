package com.mystartup.monolith.services;

import com.mystartup.monolith.services.model.Post;

import java.util.List;

public interface PostService {
  List<Post> all();
  Post getBy(String title);
  Post create(String username, String title, String content);
  void update(String title, String content);
  void delete(String title);
}
