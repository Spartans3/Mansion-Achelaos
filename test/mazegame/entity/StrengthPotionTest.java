package mazegame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrengthPotionTest {

	@Test
	public void testCreate() {
		StrengthPotion pot = new StrengthPotion();
		assertNotEquals(pot, null);
	}
	
	@Test
	public void testName() {
		StrengthPotion pot = new StrengthPotion();
		assertEquals(pot.getName(), "StrengthPotion");
	}
	
	@Test
	public void testPrice() {
		StrengthPotion pot = new StrengthPotion();
		assertEquals(pot.getPrice(), 25);
	}

}
