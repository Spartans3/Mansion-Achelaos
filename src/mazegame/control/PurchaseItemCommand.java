package mazegame.control;

import java.util.HashMap;

import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Vendor;

public class PurchaseItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getCurrentLocation().getVendor() == null) {
			return new CommandResponse("There isn't any vendor here, you can't purchase.");
		}
		
		if(thePlayer.getCurrentLocation().getNpc() !=null)
			return new CommandResponse("Enemy won't let you shop");
		
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to buy something you need to tell me which one.");
		}
		
		Vendor v = thePlayer.getCurrentLocation().getVendor();
		HashMap<String,Item> items = v.getStuff();
		
		if(items.get(userInput.getArguments().get(0)) == null) {
			return new CommandResponse("There isn't any item that named " + userInput.getArguments().get(0) );
		}else{
			Item item = items.get(userInput.getArguments().get(0));
			
			int itemPrice = item.getPrice();
			int currentGold = thePlayer.getGold();
			
			if(currentGold - itemPrice < 0)
				return new CommandResponse("You dont have enough gold. You need " + Math.abs(currentGold - itemPrice) + " more");
			
			if(thePlayer.getItems().get(item.getName().toLowerCase()) != null)
				return new CommandResponse("You can carry only one");
			
			
			if(thePlayer.getCurrentWeight() + item.getWeight() > thePlayer.getMaxWeight())
				return new CommandResponse("You can't carry this much");
			else {
				thePlayer.getItems().put(item.getName().toLowerCase(), item);
				thePlayer.setGold(currentGold - itemPrice);
				thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() + item.getWeight());
				v.getStuff().remove(item.getName().toLowerCase());
			}
			
			return new CommandResponse("You purchased " + item.getName() + ". Remaining gold = " + thePlayer.getGold());
			
		}
		
		
	}

}
