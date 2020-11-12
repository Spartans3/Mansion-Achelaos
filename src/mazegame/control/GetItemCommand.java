package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class GetItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getCurrentLocation().getItem() == null)
			return new CommandResponse("There are no items in here");
		
		if(thePlayer.getCurrentLocation().getNpc() !=null)
			return new CommandResponse("Enemy won't let you pick up the item");
		
		Item item = thePlayer.getCurrentLocation().getItem();
		
		if(thePlayer.getItems().get(item.getName().toLowerCase()) != null)
			return new CommandResponse("You can carry only one");
		
		if(thePlayer.getCurrentWeight() + item.getWeight() > thePlayer.getMaxWeight())
			return new CommandResponse("You can't carry this much");
		else {
			thePlayer.getItems().put(item.getName().toLowerCase(), item);
			thePlayer.setCurrentWeight(thePlayer.getCurrentWeight() + item.getWeight());
			thePlayer.getCurrentLocation().setItem(null);
		}
		
		return new CommandResponse(item.getName() + " picked");
		
	}

}
