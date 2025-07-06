package dev.gszczes.runnerz_demo.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  private List<Run> runs = new ArrayList<>();

  List<Run> findAll() {
    return runs;
  }

  @PostConstruct
  private void init() {
    runs.add(new Run(1,
    "Monday Morning Stroll",
    LocalDateTime.now(),
    LocalDateTime.now().plus(30, ChronoUnit.HOURS),
    3,
    Location.OUTDOOR));

    runs.add(new Run(2,
    "Tuesday Afternoon Run",
    LocalDateTime.now(),
    LocalDateTime.now().plus(60, ChronoUnit.HOURS),
    8,
    Location.OUTDOOR));

    runs.add(new Run(3,
    "Chores in the House",
    LocalDateTime.now(),
    LocalDateTime.now().plus(120, ChronoUnit.HOURS),
    1,
    Location.INDOOR));
  }
}
