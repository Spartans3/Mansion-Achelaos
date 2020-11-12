package mazegame.control;

import mazegame.entity.Character;
import mazegame.entity.Dice;
import mazegame.entity.Player;

public class AttackCommand implements Command {
	
	
	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to attack you need to tell me how.");
		}
		
		if(thePlayer.getCurrentLocation().getNpc() == null)
			return new CommandResponse("There's no one to attack");
		
		
		String cmd = (String) userInput.getArguments().get(0);
		Character enemy = thePlayer.getCurrentLocation().getNpc();
		
		switch (cmd.toLowerCase()) {
		case "swing":{
			int dmg = thePlayer.swingAttack();
			enemy.setLifePoints(enemy.getLifePoints() - dmg);
			if(enemy.getLifePoints() > 0) {
				if(enemyAttack(thePlayer, enemy))
					return new CommandResponse("You're dead.",true);
			}
			else {
				thePlayer.setGold(thePlayer.getGold() + enemy.getGold());
				thePlayer.getCurrentLocation().setNpc(null);
			}
			return new CommandResponse("You swinged("+dmg+") to the enemy , it has " + enemy.getLifePoints() + " life left. You have " + thePlayer.getLifePoints() + " life."
					+ (thePlayer.getCurrentLocation().getNpc() == null ? " You earned " +enemy.getGold() + "gold. Now  you have " +thePlayer.getGold()
					: ""));
		}
		
		case "stab":{
			int dmg = thePlayer.stabAttack();
			enemy.setLifePoints(enemy.getLifePoints() - dmg);
			if(enemy.getLifePoints() > 0) {
				if(enemyAttack(thePlayer, enemy)) {
					return new CommandResponse("You're dead.",true);
				}
			}
			else {
				thePlayer.setGold(thePlayer.getGold() + enemy.getGold());
				thePlayer.getCurrentLocation().setNpc(null);
			}
			return new CommandResponse("You stabbed("+dmg+") the enemy , it has " + enemy.getLifePoints() + " life left. You have " +thePlayer.getLifePoints() + " life."
					+ (thePlayer.getCurrentLocation().getNpc() == null ? " You earned " +enemy.getGold() + "gold .Now  you have " +thePlayer.getGold()
					: ""));
		}
		
		default:{
			if(enemyAttack(thePlayer, enemy))
				return new CommandResponse("You've made an error! Enemy takes advantage and you're dead.",true);
			
			return new CommandResponse("You've made an error! Enemy takes advantage!");
		}
		}
		
	}
	
	private boolean enemyAttack(Player thePlayer , Character enemy) {
		Dice dice = new Dice(0, 1);
		int selection = dice.roll();
		
		switch (selection) {
		case 0:{
			int dmg = enemy.swingAttack();
			thePlayer.setLifePoints(thePlayer.getLifePoints() - dmg);
			break;
		}
		case 1:{
			int dmg = enemy.stabAttack();
			thePlayer.setLifePoints(thePlayer.getLifePoints() - dmg);
			break;
		}

		default:
			break;
		}
		
		if(thePlayer.getLifePoints()<=0)
			return true;
		else
			return false;
		
	}

}
