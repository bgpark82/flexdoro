package com.bgpark.flexdoro.api.domain.pomodoro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PomodoroRepositoryTest {

    @Autowired
    private PomodoroRepository pomodoroRepository;

    @Test
    void 오늘_포모도로_조회() {
        pomodoroRepository.save(Pomodoro.builder()
                .startDateTime(LocalDateTime.of(2022, 1, 1, 0, 0, 0))
                .build());
        pomodoroRepository.save(Pomodoro.builder()
                .startDateTime(LocalDateTime.of(2022, 1, 1, 23, 59, 59))
                .build());

        List<Pomodoro> pomodoros = pomodoroRepository.findByStartDateTimeBetween(
                LocalDateTime.of(2022, 1, 1, 0, 0, 0),
                LocalDateTime.of(2022, 1, 1, 23, 59, 59));

        assertThat(pomodoros.size()).isEqualTo(2);
    }
}
