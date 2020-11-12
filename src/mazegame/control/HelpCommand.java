package mazegame.control;

import java.util.Map.Entry;

import mazegame.entity.Player;

public class HelpCommand implements Command {
	
	private String[] availableCommands = {
			"go", 
			"quit",
			"move", 
	        "look",
	        "list",
	        "get", 
	        "collect", 
	        "drop",
	        "purchase", 
	        "buy",
	        "sell",
	        "equip",
	        "unequip", 
	        "getmazestatus",
	        "get maze status", 
	        "help",
	        "flee",
	        "use",
	        "attack swing",
	        "attack stab",
	        "defend"
	};

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		String helpText ="Available commands are:\n";
			
			for (int i = 0 ; i<availableCommands.length ; i++) {
				helpText += availableCommands[i] + "   |   ";
				if(i%4 == 0)
					helpText += "\n";
			}
			
			return new CommandResponse(helpText);
				
	}

}
