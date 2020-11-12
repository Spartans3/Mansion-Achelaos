package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class DefendCommandTest {

	@Test
	public void createTest() {
		DefendCommand cmd = new DefendCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void testDefendEmpty() {
		DefendCommand cmd = new DefendCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("There's no one to defend against", r.getMessage());
	}
	
	@Test
	public void testDefendMethod() {
		DefendCommand cmd = new DefendCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation().getExit("south").getDestination());
		int life = p.getLifePoints();
		
		ParsedInput userInput = new ParsedInput();
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertTrue(life>p.getLifePoints());
	}

}
