package com.bgpark.flexdoro.api.domain.pomodoro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PomodoroRepository extends JpaRepository<Pomodoro, Long> {

    List<Pomodoro> findByStartDateTimeBetween(LocalDateTime begin, LocalDateTime end);
}
