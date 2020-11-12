package mazegame.control;

import static org.junit.Assert.*;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class GetItemCommandTest {

	@Test
	public void test() {
		GetItemCommand cmd = new GetItemCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		GetItemCommand cmd = new GetItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		
	}
	
	@Test
	public void test3() {
		GetItemCommand cmd = new GetItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertEquals("HealthPotion picked", r.getMessage());
	}

}
