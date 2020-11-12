package mazegame.control;

import mazegame.entity.Player;

public class FleeCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(thePlayer.getCurrentLocation().getNpc() ==null) {
			return new CommandResponse("There's no need to flee");
		}
		
		thePlayer.setCurrentLocation(thePlayer.getLastLocation());
		
		return new CommandResponse("You ran away to your last room.\n" + thePlayer.getCurrentLocation().toString());
		
	}

}
