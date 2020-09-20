package com.mystartup.monolith.services.impl;

import com.mystartup.monolith.services.model.User;
import com.mystartup.monolith.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class UserServiceImpl implements UserService {

  // Public

  public List<User> all() {
    return List.of(
      new User("Ivan", "Petrov", 1),
      new User("Petr", "Ivanov", 2)
    );
  }

  public User getBy(String lastName) {
    return new User("Ivan", "Petrov", 1);
  }

  public User create(String firstName, String lastName, int age) {
    return User.builder()
      .firstName(firstName)
      .lastName(lastName)
      .age(age)
      .build();
  }

  public void update(String firstName, String lastName, int age) {
  }

  public void delete(String lastName) {
  }
}
