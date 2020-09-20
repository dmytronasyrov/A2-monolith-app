package com.mystartup.monolith.model;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public final class Post {

  // Variables

  @Setter(AccessLevel.NONE)
  private final String title;
  private String content;
  private final String username;
}
