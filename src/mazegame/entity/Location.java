package mazegame.entity;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Location {
	private HashMap exits;
	private String description;
	private String label;
	private Vendor vendor;
	private Character npc;
	private Item item;

	public Location() {
	}

	public Location(String description, String label) {
		this.setDescription(description);
		this.setLabel(label);
		exits = new HashMap();
	}

	public boolean addExit(String exitLabel, Exit theExit) {
		if (exits.containsKey(exitLabel))
			return false;
		exits.put(exitLabel, theExit);
		return true;
	}

	public Exit getExit(String exitLabel) {
		return (Exit) exits.get(exitLabel);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String availableExits() {
		StringBuilder returnMsg = new StringBuilder();
		for (Object label : this.exits.keySet()) {
			returnMsg.append("[" + label.toString() + "] ");
		}
		return returnMsg.toString();
	}
	
    public boolean containsExit(String exitLabel) {
    	return exits.containsKey(exitLabel);
    }


	public String toString() {
		String placeInfo = "";
		placeInfo += "**********\n" + this.label;
		placeInfo += "\n**********\n";
		placeInfo += "Exits found :: " + availableExits() + "\n**********\n";
		placeInfo += this.description + "\n**********\n";
		
		if(getVendor() !=null) {
				placeInfo +="Vendor items:\n";
				if(getVendor().getStuff().isEmpty()) {
					placeInfo += "EMPTY";
				}
				
				for (Entry<String,Item> entry : getVendor().getStuff().entrySet()) {
					placeInfo += entry.getKey() + "(" +entry.getValue().getPrice() + ")\t";
				}
				placeInfo += "\n**********\n";
		}
		
		if(getNpc() !=null) {
			placeInfo += "An enemy is here! Get ready to fight!!!";
			
		}
		
		return  placeInfo; 
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Character getNpc() {
		return npc;
	}

	public void setNpc(Character npc) {
		this.npc = npc;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
