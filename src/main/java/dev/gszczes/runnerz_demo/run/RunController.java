package dev.gszczes.runnerz_demo.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/runs")
public class RunController {

  private final RunRepository runRepository;

  public RunController(RunRepository runRepository) {
    this.runRepository = runRepository;
  }

  @GetMapping("")
  List<Run> findAll() {
    return runRepository.findAll();
  }

  @GetMapping("/{id}")
  Run findById(@PathVariable Integer id) {
    Optional<Run> run = runRepository.findById(id);

    if (run.isEmpty()) {
      throw new RunNotFoundException();
    } else {
      return run.get();
    }
  }

  // post
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  void create(@Valid @RequestBody Run run) {
      runRepository.create(run);
  }

  // put
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void update(@PathVariable Integer id, @Valid @RequestBody Run run) {
      runRepository.update(run, id);
  }

  // delete
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void delete(@PathVariable Integer id) {
    runRepository.delete(id);
  }
}
