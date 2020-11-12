package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class FleeCommandTest {

	@Test
	public void test() {
		FleeCommand cmd = new FleeCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {

		FleeCommand cmd = new FleeCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("There's no need to flee", r.getMessage());
	
	}
	
	@Test
	public void test3() {
		FleeCommand cmd = new FleeCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		p.setCurrentLocation(data.getStartingLocation().getExit("south").getDestination());
		p.setLastLocation(data.getStartingLocation());
		ParsedInput userInput = new ParsedInput();
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("You ran away to your last room.\n" + p.getCurrentLocation().toString(), r.getMessage());
	
	
		
	}

}
