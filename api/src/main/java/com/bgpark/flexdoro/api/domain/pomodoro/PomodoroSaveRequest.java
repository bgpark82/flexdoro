package com.bgpark.flexdoro.api.domain.pomodoro;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PomodoroSaveRequest {

    private int minutes;
    private String title;

    public Pomodoro toPomodoro(LocalDateTime start, LocalDateTime end) {
        return Pomodoro.builder()
                .minutes(minutes)
                .title(title)
                .startDateTime(start)
                .endDateTime(end)
                .build();
    }
}
