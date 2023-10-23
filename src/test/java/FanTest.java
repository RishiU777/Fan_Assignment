
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.test.Fan;
import com.test.FanDirection;

class FanTest {

	@DisplayName("Fan is Off when starting")
	@Test
	void testWhenFanIsInitiated() {
		assertFalse(new Fan().isON());
	}

	@DisplayName("Fan Direction is left when starting")
	@Test
	void testWhenFanIsInitiatedWithLEFT() {
		Fan fan = new Fan();
		assertEquals(FanDirection.CLOCKWISE, fan.getCurrentDirection());
	}

	@DisplayName("When +pullSpeedControllerCord")
	@Test
	void testWhenFirstLeftPull() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();;
		assertEquals(1, fan.getCurrentSpeed());
	}

	@DisplayName("When ++pullSpeedControllerCord")
	@Test
	void testWhenSecondLeftPull() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertEquals(2, fan.getCurrentSpeed());
	}

	@DisplayName("When +++pullSpeedControllerCord")
	@Test
	void testWhenThirdLeftPull() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertEquals(FanDirection.CLOCKWISE, fan.getCurrentDirection());
		assertEquals(3, fan.getCurrentSpeed());
	}

	@DisplayName("When ++++pullSpeedControllerCord is OFF")
	@Test
	void testWhenFourthLeftPullIfOff() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertFalse(fan.isON());
	}

	@DisplayName("When +pullSpeedControllerCord +directioncordpull")
	@Test
	void testWhenFirstLeftPullAndRightIsReversed() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullDirectionControllerCord();
		assertEquals(1, fan.getCurrentSpeed());
		assertEquals(FanDirection.ANTI_CLOCKWISE, fan.getCurrentDirection());
	}
	@DisplayName("When ++directioncordpull is Clockwise")
	@Test
	void testWhenTwoTimesRightPullIsLeft() {
		Fan fan = new Fan();
		fan.pullDirectionControllerCord();
		fan.pullDirectionControllerCord();
		assertEquals(FanDirection.CLOCKWISE, fan.getCurrentDirection());
	}
}
