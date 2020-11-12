package mazegame.control;

import static org.junit.Assert.*;

import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Player;

public class MazeStatusCommandTest {

	@Test
	public void test() {
		MazeStatusCommand cmd = new MazeStatusCommand();
		assertNotNull(cmd);
	}
	
	@Test
	public void test2() {
		MazeStatusCommand cmd = new MazeStatusCommand();
		
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertNotNull(r.getMessage());
	}
	
	@Test
	public void test3() {
		MazeStatusCommand cmd = new MazeStatusCommand();
		
		HardCodedData data = new HardCodedData();
		Player p = data.createMainCharacter("test");
		p.setCurrentLocation(data.getStartingLocation());
		
		ParsedInput userInput = new ParsedInput();
		CommandResponse r = cmd.execute(userInput, p);
		
		assertEquals(
				"There are 3 vendors, 5 NPC(1 boss) and 12 rooms in this mansion. \n" +
				"Your\thp\tagi\tgold\tstr\tweight\tblock\n" +
				"\t"+p.getLifePoints() + "/" +p.getMaxLifePoints()+
				"\t"+p.getAgility()+
				"\t"+p.getGold()+
				"\t"+p.getStrength()+
				"\t"+p.getCurrentWeight() + "/" + p.getMaxWeight()+
				"\t"+p.getBlockChance()
				, r.getMessage());
	}

}
