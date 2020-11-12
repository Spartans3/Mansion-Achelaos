package mazegame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgilityPotionTest {

	@Test
	public void testCreate() {
		AgilityPotion pot = new AgilityPotion();
		assertNotEquals(pot, null);
	}
	
	@Test
	public void testName() {
		AgilityPotion pot = new AgilityPotion();
		assertEquals(pot.getName(), "AgilityPotion");
	}
	
	@Test
	public void testPrice() {
		AgilityPotion pot = new AgilityPotion();
		assertEquals(pot.getPrice(), 25);
	}

}
