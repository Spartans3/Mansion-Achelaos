package mazegame.entity;

import java.util.HashMap;

public class Vendor {
	private HashMap<String,Item> stuff;
	private String name;
	
	public Vendor() {
		stuff = new HashMap<String,Item>();
	}
	
	
	public HashMap<String,Item> getStuff() {
		return stuff;
	}
	public void setStuff(HashMap<String,Item> stuff) {
		this.stuff = stuff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
