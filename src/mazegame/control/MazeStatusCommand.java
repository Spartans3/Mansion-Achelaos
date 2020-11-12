package mazegame.control;

import mazegame.entity.Player;

public class MazeStatusCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		return new CommandResponse(
				"There are 3 vendors, 5 NPC(1 boss) and 12 rooms in this mansion. \n" +
				"Your\thp\tagi\tgold\tstr\tweight\tblock\n" +
				"\t"+thePlayer.getLifePoints() + "/" +thePlayer.getMaxLifePoints()+
				"\t"+thePlayer.getAgility()+
				"\t"+thePlayer.getGold()+
				"\t"+thePlayer.getStrength()+
				"\t"+thePlayer.getCurrentWeight() + "/" + thePlayer.getMaxWeight()+
				"\t"+thePlayer.getBlockChance()
				);
	}

}
