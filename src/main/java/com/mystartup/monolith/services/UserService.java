package com.mystartup.monolith.services;

import com.mystartup.monolith.services.model.User;

import java.util.List;

public interface UserService {
  List<User> all();
  User getBy(String lastName);
  User create(String firstName, String lastName, int age);
  void update(String firstName, String lastName, int age);
  void delete(String lastName);
}
