package mazegame.control;

import mazegame.entity.Player;

public class DropItemCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to drop an item you need to tell me which one.");
		}
		
		if(thePlayer.getItems().get(userInput.getArguments().get(0)) !=null )
			thePlayer.getItems().remove(userInput.getArguments().get(0));
		else
			return new CommandResponse("No such item");
		
		return new CommandResponse(userInput.getArguments().get(0) + " destroyed");
		
	}

}
