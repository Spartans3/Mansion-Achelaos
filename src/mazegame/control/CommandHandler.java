package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import mazegame.entity.Player;

public class CommandHandler {
	private HashMap<String, Command> availableCommands;
	private ArrayList<String> commands;
	private Parser theParser;
	
	public CommandHandler () {
		availableCommands = new HashMap<String, Command>();
		commands = new ArrayList<String>();
		setupCommands();
		theParser = new Parser(popArrayList());
	}
	
	private void setupCommands () {
		availableCommands.put("go", new MoveCommand());
		availableCommands.put("quit", new QuitCommand());
		availableCommands.put("move", new MoveCommand());
        availableCommands.put("look",  new LookCommand()); 
        availableCommands.put("list", new ListItemsCommand());
        availableCommands.put("get", new GetItemCommand());
        availableCommands.put("collect", new GetItemCommand());
        availableCommands.put("drop", new DropItemCommand());
        availableCommands.put("purchase", new PurchaseItemCommand());
        availableCommands.put("buy", new PurchaseItemCommand());
        availableCommands.put("sell", new SellItemCommand());
        availableCommands.put("equip", new EquipItemCommand());
        availableCommands.put("unequip", new UnequipItemCommand());
        availableCommands.put("getmazestatus", new MazeStatusCommand());
        availableCommands.put("get maze status", new MazeStatusCommand());
        availableCommands.put("help", new HelpCommand());
        availableCommands.put("flee", new FleeCommand());
        availableCommands.put("attack", new AttackCommand());
        availableCommands.put("defend", new DefendCommand());
        availableCommands.put("use", new EquipItemCommand());
	}
	
	private ArrayList<String> popArrayList () {
		Set<String> set = availableCommands.keySet();
		ArrayList <String> temp = new ArrayList<String> ();
		for (String key : set) {
			temp.add(key);
		}
		return temp;
	}
	
	public CommandResponse processTurn (String userInput, Player thePlayer) {
		ParsedInput validInput = theParser.parse(userInput);
		Command theCommand = (Command) availableCommands.get(validInput.getCommand());
		if(theCommand == null) {
			return new HelpCommand().execute(validInput, thePlayer);
		}
		return theCommand.execute(validInput, thePlayer);
	}
	
}
