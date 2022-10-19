package com.bgpark.flexdoro.api.domain.pomodoro;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pomodoros")
@RequiredArgsConstructor
public class PomodoroController {

  private final PomodoroRepository pomodoroRepository;

  @PostMapping
  public ResponseEntity create(@RequestBody PomodoroSaveRequest request) {
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = start.plusMinutes(request.getMinutes());

    pomodoroRepository.save(request.toPomodoro(start, end));
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<Pomodoro>> findAll() {
    LocalDateTime start = LocalDate.now().atTime(0, 0, 0);
    LocalDateTime end = LocalDate.now().atTime(23, 59, 59);

    return ResponseEntity.ok(pomodoroRepository.findByStartDateTimeBetween(start, end));
  }
}
