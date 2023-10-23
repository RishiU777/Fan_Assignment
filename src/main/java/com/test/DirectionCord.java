package com.test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DirectionCord implements IFanCord {
private final State state;
	@Override
	public void pull() {
		state.setCurrentDirection(state.getCurrentDirection().reverse());
	}

}
