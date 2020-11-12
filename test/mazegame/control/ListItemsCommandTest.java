package mazegame.control;

import static org.junit.Assert.*;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class ListItemsCommandTest {

	@Test
	public void test() {
		ListItemsCommand cmd = new ListItemsCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		ListItemsCommand cmd = new ListItemsCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
	}
	
	@Test
	public void test3() {
		ListItemsCommand cmd = new ListItemsCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertEquals("You don't have any items.Also you have " + p.getGold() + " gold", r.getMessage());
	}

}
