package mazegame.control;

import mazegame.entity.Player;
import mazegame.entity.Character;
import mazegame.entity.Dice;

public class DefendCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getCurrentLocation().getNpc() == null)
			return new CommandResponse("There's no one to defend against");
		
		Character enemy = thePlayer.getCurrentLocation().getNpc();
		int enemyDmg = enemyAttack(enemy);
		
		if(thePlayer.reflectDamage()) {
			enemy.setLifePoints(enemy.getLifePoints() - enemyDmg);
			if(enemy.getLifePoints() <= 0) {
				thePlayer.setGold(thePlayer.getGold() + enemy.getGold());
				thePlayer.getCurrentLocation().setNpc(null);
				return new CommandResponse("You've succesfully reflected the damage.Enemy is dead.You earned"
						+ enemy.getGold() + ". Now you have "+ thePlayer.getGold() + " gold");
			}
			return new CommandResponse("You've succesfully reflected the damage.Enemy has "+ enemy.getLifePoints() +" life left");
		}else {
			thePlayer.setLifePoints(thePlayer.getLifePoints() - enemyDmg);
			if(thePlayer.getLifePoints() <= 0)
				return new CommandResponse("You're dead.",true);
			
			return new CommandResponse("You've failed to block the attack.You took "+ enemyDmg 
					+ " dmg. You have " + thePlayer.getLifePoints() + " life left.");
		}
		
	}

	public int enemyAttack(Character enemy) {
		Dice dice = new Dice(0, 1);
		int selection = dice.roll();
		
		switch (selection) {
		case 0:{
			return enemy.swingAttack();
		}
		case 1:{
			return  enemy.stabAttack();
		}

		default:
			return 0;
		}
	}
	
}
