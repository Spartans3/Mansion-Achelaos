package mazegame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testCreate() {
		Dice dice = new Dice();
		assertNotEquals(dice, null);
	}
	
	@Test
	public void testRoll() {
		Dice dice = new Dice();
		assertNotEquals(dice.roll(), 7);
	}
	
	@Test
	public void testCustomRoll() {
		Dice dice = new Dice(2,2);
		assertEquals(dice.roll(), 2);
	}

}
