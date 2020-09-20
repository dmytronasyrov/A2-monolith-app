package com.mystartup.monolith.services.model;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public final class User {

  // Variables

  @Setter(AccessLevel.NONE)
  private final String firstName;

  @Setter(AccessLevel.NONE)
  private final String lastName;

  private final int age;

  // Public

  public String getFullName() {
    return String.format("%s %s", firstName, lastName);
  }
}
