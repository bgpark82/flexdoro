package com.bgpark.flexdoro.api.domain.pomodoro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pomodoro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minutes;

    private String title;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
