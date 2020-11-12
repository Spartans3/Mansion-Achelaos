package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class EquipItemCommandTest {

	@Test
	public void test() {
		EquipItemCommand cmd = new EquipItemCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		EquipItemCommand cmd = new EquipItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		ParsedInput userInput = new ParsedInput();

		CommandResponse r = cmd.execute(userInput, p);
		assertEquals(r.getMessage(), "If you want to equip an item you need to tell me which one.");
	}
	
	@Test
	public void test3() {
		EquipItemCommand cmd = new EquipItemCommand();
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		
		ParsedInput userInput = new ParsedInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("junk");
		userInput.setArguments(list);
		
		CommandResponse r = cmd.execute(userInput, p);
		assertEquals(r.getMessage(), "There's no such item exist in your inventory.");
	}

}
