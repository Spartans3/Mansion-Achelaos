package mazegame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealthPotionTest {

	@Test
	public void testCreate() {
		HealthPotion pot = new HealthPotion();
		assertNotEquals(pot, null);
	}
	
	@Test
	public void testName() {
		HealthPotion pot = new HealthPotion();
		assertEquals(pot.getName(), "HealthPotion");
	}
	
	@Test
	public void testPrice() {
		HealthPotion pot = new HealthPotion();
		assertEquals(pot.getPrice(), 15);
	}

}
