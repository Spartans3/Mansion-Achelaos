package mazegame.control;

import static org.junit.Assert.*;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class PurchaseItemCommandTest {

	@Test
	public void test() {
		PurchaseItemCommand cmd = new PurchaseItemCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		PurchaseItemCommand cmd = new PurchaseItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertTrue(r.getMessage() != null);
	}
	
	@Test
	public void test3() {
		PurchaseItemCommand cmd = new PurchaseItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertEquals("There isn't any vendor here, you can't purchase.", r.getMessage());
	}

}
