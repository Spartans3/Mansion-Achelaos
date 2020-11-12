package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class UnequipItemCommandTest {

	@Test
	public void test() {
		UnequipItemCommand cmd = new UnequipItemCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		UnequipItemCommand cmd = new UnequipItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		ParsedInput userInput = new ParsedInput();

		CommandResponse r = cmd.execute(userInput, p);
		assertEquals(r.getMessage(), "If you want to unequip something you need to tell me which one.");
	}
	
	@Test
	public void test3() {
		UnequipItemCommand cmd = new UnequipItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		ParsedInput userInput = new ParsedInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("junk");
		userInput.setArguments(list);
		
		CommandResponse r = cmd.execute(userInput, p);
		assertEquals(r.getMessage(), "You can't unequip an item like that.");
	}

}
