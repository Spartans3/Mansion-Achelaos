package mazegame.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class AttackCommandTest {
	
	@Test
	public void createTest() {
		AttackCommand cmd = new AttackCommand();
		assertNotNull(cmd);
	}

	@Test
	public void testAttackEmpty() {
		AttackCommand cmd = new AttackCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("swing");
		userInput.setArguments(list);
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("There's no one to attack", r.getMessage());
	}
	
	@Test
	public void testAttackMethod() {
		AttackCommand cmd = new AttackCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
//		ArrayList<String> list = new ArrayList<>();
//		list.add("swing");
//		userInput.setArguments(list);
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("If you want to attack you need to tell me how.", r.getMessage());
	}

}
