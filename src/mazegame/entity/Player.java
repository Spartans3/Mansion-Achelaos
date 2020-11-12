package mazegame.entity;

public class Player extends Character {
	
	private Location currentLocation;
	private Location lastLocation;
    public Player()
    {
    }

    public Player(String name)
	{
	    super (name);
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	

}
