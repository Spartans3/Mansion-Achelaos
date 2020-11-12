package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class SellItemCommandTest {

	@Test
	public void test() {
		SellItemCommand cmd = new SellItemCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		SellItemCommand cmd = new SellItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);

		assertTrue(r.getMessage() != null);
	}
	
	@Test
	public void test3() {
		SellItemCommand cmd = new SellItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);

		assertEquals("There isn't any vendor here, you can't purchase.", r.getMessage());
		
	}

}
