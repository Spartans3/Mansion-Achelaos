package mazegame.control;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;

public class UnequipItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to unequip something you need to tell me which one.");
		}
		
		Item item = (Item) thePlayer.getItems().get(userInput.getArguments().get(0));
		
		if(item instanceof Armor) {
			
			thePlayer.setAgility(thePlayer.getAgility() - item.getAgility());
			thePlayer.setMaxLifePoints(thePlayer.getMaxLifePoints() - item.getLifePoints());
			thePlayer.setArmor(null);
			
			return new CommandResponse("You equipped "+ item.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" Life = " + thePlayer.getLifePoints() + " / " + thePlayer.getMaxLifePoints());
			
		}else if(item instanceof Weapon) {
			thePlayer.setStrength(thePlayer.getStrength() - item.getStrength());
			thePlayer.setAgility(thePlayer.getAgility() - item.getAgility());
			thePlayer.setWeapon(null);
			
			return new CommandResponse("You unequipped "+ item.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" Strength = " +thePlayer.getStrength());
			
		}else if(item instanceof Shield) {
			thePlayer.setAgility(thePlayer.getAgility() - item.getAgility());
			thePlayer.setBlockChance(0);
			thePlayer.setShield(null);
			
			return new CommandResponse("You equipped "+ item.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" BlockChance = " +thePlayer.getBlockChance());
		}
		
		
		return new CommandResponse("You can't unequip an item like that.");
		
		
		
	}

}
