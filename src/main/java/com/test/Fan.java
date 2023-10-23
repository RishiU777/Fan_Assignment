package com.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fan {
	private final State state;
	private final IFanCord speedControllerCord;
	private final IFanCord directionCord;

	public Fan() {
		this.state = new State(0, 3, FanDirection.CLOCKWISE);
		this.speedControllerCord = new SpeedControllerCord(state);
		this.directionCord = new DirectionCord(state);
	}

	public boolean isON() {
		return getCurrentSpeed() > 0;
	}

	public int getCurrentSpeed() {
		return this.state.getSpeed();
	}

	public FanDirection getCurrentDirection() {
		return this.state.getCurrentDirection();
	}

	public void pullSpeedControllerCord() {
		log.info("Left Cord Pulled");
		this.speedControllerCord.pull();
		log.info("Current speed {}", getCurrentSpeed());
		if (getCurrentSpeed() == this.state.getMaximumSpeed()) {
			log.info("Fan is in now Max Speed");
		}
		if (!isON())
			log.info("Fan is off now");
	}

	public void pullDirectionControllerCord() {
		log.info("Right Cord Pulled");
		this.directionCord.pull();
		log.info("Current Direction {}", getCurrentDirection());
	}

}
