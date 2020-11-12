package mazegame.control;

import mazegame.entity.AgilityPotion;
import mazegame.entity.Armor;
import mazegame.entity.HealthPotion;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.StrengthPotion;
import mazegame.entity.Weapon;

public class EquipItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to equip an item you need to tell me which one.");
		}
		
		Item item = (Item) thePlayer.getItems().get(userInput.getArguments().get(0));
		
		if(item instanceof Armor) {
			
			if(thePlayer.getArmor() !=null) 
				new UnequipItemCommand().execute(userInput, thePlayer);
			
			Armor a = (Armor) item;
			
			thePlayer.setAgility(thePlayer.getAgility() + a.getAgility());
			thePlayer.setMaxLifePoints(thePlayer.getMaxLifePoints() + a.getLifePoints());
			thePlayer.setArmor(a);
//			thePlayer.setLifePoints(thePlayer.getLifePoints() + a.getLifePoints());
			
			return new CommandResponse("You equipped "+ a.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" Life = " + thePlayer.getLifePoints() + " / " + thePlayer.getMaxLifePoints());
			
		}
		else if(item instanceof Weapon) {
			
			if(thePlayer.getWeapon() !=null) 
				new UnequipItemCommand().execute(userInput, thePlayer);
			
			Weapon w = (Weapon) item;
			
			thePlayer.setStrength(thePlayer.getStrength() + w.getStrength());
			thePlayer.setAgility(thePlayer.getAgility() + w.getAgility());
			thePlayer.setWeapon(w);
			
			return new CommandResponse("You equipped "+ w.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" Strength = " +thePlayer.getStrength());
			
		}
		else if(item instanceof Shield) {
			
			if(thePlayer.getShield() !=null) 
				new UnequipItemCommand().execute(userInput, thePlayer);
			
			Shield s = (Shield) item;
			
			thePlayer.setAgility(thePlayer.getAgility() + s.getAgility());
			thePlayer.setBlockChance(s.getBlockChance());
			thePlayer.setShield(s);
			
			return new CommandResponse("You equipped "+ s.getName()+ 
					". Agility = " + thePlayer.getAgility() + 
					" BlockChance = " +thePlayer.getBlockChance());
		}
		else if(item instanceof HealthPotion) {
			
			HealthPotion hp = (HealthPotion) item;
			
			int maxLife = thePlayer.getMaxLifePoints();
			int potionLife = hp.getLifePoints();
			int currentLife = thePlayer.getLifePoints();
			currentLife += potionLife;
			if(currentLife>maxLife)
				currentLife = maxLife;
			thePlayer.setLifePoints(currentLife);
			
			thePlayer.getItems().remove(userInput.getArguments().get(0));
			thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() - hp.getWeight());
			
			return new CommandResponse("Your health is " + currentLife + " / " + maxLife +" now.");
			
		}
		else if(item instanceof AgilityPotion) {
			AgilityPotion ap = (AgilityPotion) item;
			int aglility = ap.getAgility();
			int currentAgility = thePlayer.getAgility();
			currentAgility += aglility;
			
			thePlayer.setAgility(currentAgility);
			
			thePlayer.getItems().remove(userInput.getArguments().get(0));
			thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() - ap.getWeight());
			
			return new CommandResponse("Your agility is " + currentAgility + " now.");
			
		}
		else if(item instanceof StrengthPotion) {
			
			StrengthPotion sp = (StrengthPotion) item;
			int aglility = sp.getStrength();
			int currentStrength = thePlayer.getStrength();
			currentStrength += aglility;
			
			thePlayer.setStrength(currentStrength);
			
			thePlayer.getItems().remove(userInput.getArguments().get(0));
			thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() - sp.getWeight());
			
			return new CommandResponse("Your strength is " + currentStrength + " now.");
			
		}
		
		
		return new CommandResponse("There's no such item exist in your inventory.");
		
		
	}

}
