package mazegame.control;

import java.util.HashMap;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Vendor;
import mazegame.entity.Weapon;

public class SellItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getCurrentLocation().getVendor() == null) {
			return new CommandResponse("There isn't any vendor here, you can't purchase.");
		}
		
		if(thePlayer.getCurrentLocation().getNpc() !=null)
			return new CommandResponse("Enemy won't let you shop");
		
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to sell something you need to tell me which one.");
		}
		
		Vendor v = thePlayer.getCurrentLocation().getVendor();
		HashMap<String, Item> userItems = thePlayer.getItems();
		
		if(userItems.get(userInput.getArguments().get(0)) == null) {
			return new CommandResponse("You don't have an item named like that");
		}else {
			Item item = userItems.get(userInput.getArguments().get(0)) ;
			
			if(item instanceof Weapon || item instanceof Armor || item instanceof Shield)
				new UnequipItemCommand().execute(userInput, thePlayer);
			
			int vendorPrice = (int)(item.getPrice()*(80f/100.0f));
			thePlayer.setGold(thePlayer.getGold() +vendorPrice);
			thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() - item.getWeight());
			thePlayer.getItems().remove(item.getName().toLowerCase());
			
			v.getStuff().put(item.getName().toLowerCase() , item);
			
			return new CommandResponse("You sold " + item.getName() + ". Current gold = " + thePlayer.getGold());
		}
		
		
		
		
	}

}
