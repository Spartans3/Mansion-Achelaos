package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.HealthPotion;
import mazegame.entity.Player;

public class DropItemCommandTest {

	@Test
	public void test() {
		DropItemCommand cmd = new DropItemCommand();
		assertTrue(cmd != null);
	}
	
	@Test
	public void testDropEmpty() {
		DropItemCommand cmd = new DropItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		ParsedInput userInput = new ParsedInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("test");
		userInput.setArguments(list);
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals("No such item", r.getMessage());
	}
	
	@Test
	public void testDropMethod() {
		DropItemCommand cmd = new DropItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		p.getItems().put("testItem", new HealthPotion());
		ParsedInput userInput = new ParsedInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("testItem");
		userInput.setArguments(list);
		
		
		
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
		assertEquals(userInput.getArguments().get(0) + " destroyed", r.getMessage());
	}


}
