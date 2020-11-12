package mazegame.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void testSwing() {
		Character c = new Character();
		c.setAgility(20);
		c.setStrength(20);
		assertNotEquals(c.swingAttack(), 0);
	}
	
	@Test
	public void testLife() {
		Character c = new Character();
		c.setLifePoints(-50);
		assertEquals(c.getLifePoints(), 0);
	}
	
	@Test
	public void testStab() {
		Character c = new Character();
		c.setAgility(20);
		c.setStrength(20);
		assertNotEquals(c.stabAttack(), 0);
	}
	
	

}
