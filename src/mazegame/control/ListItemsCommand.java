package mazegame.control;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class ListItemsCommand implements Command{

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getItems().size() == 0)
			return new CommandResponse("You don't have any items.Also you have " + thePlayer.getGold() + " gold");
		
		StringBuilder names = new StringBuilder();
		HashMap<String,Item> items = thePlayer.getItems();
		int it  = 1;
		
		for (Entry<String,Item> entry : items.entrySet()) {
			names.append(it + "-" + entry.getKey() + "\n");
			it++;
		}
		
		return new CommandResponse(names.toString());
	}

}
