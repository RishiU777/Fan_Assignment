package com.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class State {
	@Setter
    private int speed;
    private final int maximumSpeed;
    @Setter
    private FanDirection currentDirection;
}
