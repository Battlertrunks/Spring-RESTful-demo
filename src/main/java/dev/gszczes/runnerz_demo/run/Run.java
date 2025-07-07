package dev.gszczes.runnerz_demo.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
  Integer id,
  @NotEmpty
  String title,
  LocalDateTime startedOn,
  LocalDateTime completedOn,
  @Positive
  Integer miles,
  Location location
) {
  public Run {
    if (startedOn.isAfter(completedOn)) {
      throw new IllegalArgumentException("Completed On must be after Started On.");
    }

    if (title.isEmpty()) {
      throw new IllegalArgumentException("Title is empty");
    }
  }
}
