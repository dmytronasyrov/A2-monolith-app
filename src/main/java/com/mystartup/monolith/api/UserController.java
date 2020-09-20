package com.mystartup.monolith.api;

import com.mystartup.monolith.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public final class UserController {

  // Variables

  private final UserService userService;

  // Constructors

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // API
}
