package com.test;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpeedControllerCord implements IFanCord {
	private final State state;

	@Override
	public void pull() {
		if(state.getSpeed()<state.getMaximumSpeed())
			state.setSpeed(state.getSpeed()+1);
		else
			state.setSpeed(0);
	}

}
