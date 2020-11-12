package mazegame.boundary;

import mazegame.entity.Location;
import mazegame.entity.Player;

public interface IMazeData {
	Location getStartingLocation();
	String getWelcomeMessage();
	Player createMainCharacter(String name);
}
