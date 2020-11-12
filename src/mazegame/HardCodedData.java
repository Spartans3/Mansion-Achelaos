package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.Exit;
import mazegame.entity.HealthPotion;
import mazegame.entity.Item;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.StrengthPotion;
import mazegame.entity.Vendor;
import mazegame.entity.Weapon;
import mazegame.entity.AgilityPotion;
import mazegame.entity.Armor;
import mazegame.entity.Character;

public class HardCodedData implements IMazeData {
	private Location startUp;
	
	public HardCodedData()
	{
		createLocations();
	}
	
	public Location getStartingLocation()
	{
		return startUp;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the Mansion Achelaos";
	}
	
	
	private void createLocations () 
	{
		
		startUp = new Location("a classic mansion entrance with a coat hanger", "Entrance");
		Location entranceHall = new Location("a long hall with a guard", "Entrance hall");
		Location bath = new Location("a well decorated elite bath", "Bath");
		Location secretPassage = new Location("a room with full of dark energy", "Secret Passage");
		Location kitchen = new Location("a small kitchen with a vendor in it", "Kitchen");
		Location cellar = new Location("a cellar with full of dust and stuff", "Cellar");
		Location bedroomHall = new Location("the great hall of the mansion with full of paths", "Bedroom Hall");
		Location garden = new Location("a small garden surrounded with flowers and there's a vendor waiting for you", "Garden");
		Location firstBedroom = new Location("a stylish bedroom for parents, there's a guard", "Bedroom");
		Location secondBedroom = new Location("a small bedroom with a floor bed, there's a guard", "Bedroom");
		Location garret = new Location("a garret with old stuff, look carefully", "Garret");
		Location library = new Location("a big library with a guard and a vendor", "Library");
		Location outside = new Location("you've finally made it to outside! Congratz! The game is over. Enter quit to finish the game.", "Outside");
		
		
		
		
		// Connect Locations
		startUp.addExit("east", new Exit("", kitchen));
		startUp.addExit("south", new Exit("", entranceHall));
		startUp.addExit("southwest", new Exit("", garden));
		
		kitchen.addExit("west", new Exit("", startUp));
		kitchen.addExit("south", new Exit("", bath));
		
		bath.addExit("east", new Exit("", secretPassage));
		bath.addExit("north", new Exit("", kitchen));
		bath.addExit("west", new Exit("", entranceHall));
		
		secretPassage.addExit("west", new Exit("", bath));
		secretPassage.addExit("east", new Exit("you see the exit in the east", outside));
		
		entranceHall.addExit("west", new Exit("", garden));
		entranceHall.addExit("south", new Exit("", cellar));
		entranceHall.addExit("north", new Exit("", startUp));
		entranceHall.addExit("east", new Exit("", bath));
		
		cellar.addExit("north", new Exit("", entranceHall));
		cellar.addExit("west", new Exit("", bedroomHall));
		cellar.addExit("southwest", new Exit("", library));
		
		garden.addExit("east", new Exit("", entranceHall));
		garden.addExit("northeast", new Exit("", startUp));
		garden.addExit("south", new Exit("", bedroomHall));
		
		bedroomHall.addExit("north", new Exit("", garden));
		bedroomHall.addExit("east", new Exit("", cellar));
		bedroomHall.addExit("south", new Exit("", library));
		bedroomHall.addExit("southwest", new Exit("", garret));
		bedroomHall.addExit("west", new Exit("", secondBedroom));
		bedroomHall.addExit("northwest", new Exit("", firstBedroom));
		
		library.addExit("north", new Exit("", bedroomHall));
		library.addExit("northeast", new Exit("", cellar));
		library.addExit("west", new Exit("", garret));
		
		garret.addExit("northeast", new Exit("", bedroomHall));
		garret.addExit("east", new Exit("", library));
		
		firstBedroom.addExit("southeast", new Exit("", bedroomHall));
		
		secondBedroom.addExit("east", new Exit("", bedroomHall));
		
		

		
		//Items
		Item hp1 = new HealthPotion();
		Item hp2 = new HealthPotion();
		Item hp3 = new HealthPotion();
		Item hp4 = new HealthPotion();
		Item hp5 = new HealthPotion();
		
		
		Item ag1 = new AgilityPotion();
		Item ag2 = new AgilityPotion();
		Item ag3 = new AgilityPotion();
		
		Item st1 = new StrengthPotion();
		Item st2 = new StrengthPotion();
		Item st3 = new StrengthPotion();
		
		//Weapon
		Weapon sword = new Weapon("ExcaliburSword");
		sword.setAgility(5);
		sword.setPrice(150);
		sword.setStrength(50);
		
		Weapon basicSword = new Weapon("BasicSword");
		basicSword.setAgility(10);
		basicSword.setPrice(40);
		basicSword.setStrength(20);
		sword.setWeight(5);
		
		Weapon spear = new Weapon("SpartanSpear");
		spear.setAgility(5);
		spear.setPrice(70);
		spear.setStrength(35);
		spear.setWeight(6);
		
		Weapon dagger = new Weapon("LokiDagger");
		dagger.setAgility(45);
		dagger.setPrice(150);
		dagger.setStrength(25);
		dagger.setWeight(2);
		
		//Shield
		Shield buckler = new Shield("Buckler");
		buckler.setAgility(10);
		buckler.setBlockChance(15);
		buckler.setPrice(50);
		buckler.setWeight(2);
		
		Shield kite = new Shield("KiteShield");
		kite.setAgility(5);
		kite.setBlockChance(25);
		kite.setPrice(60);
		kite.setWeight(4);

		
		//Armor
		Armor robe = new Armor("Robe");
		robe.setAgility(5);
		robe.setLifePoints(50);
		robe.setPrice(40);
		robe.setWeight(2);
		
		Armor plate = new Armor("WarPlate");
		plate.setAgility(10);
		plate.setLifePoints(50);
		plate.setPrice(70);
		plate.setWeight(5);
		
		Armor vest = new Armor("ChainmailVest");
		vest.setAgility(15);
		vest.setLifePoints(35);
		vest.setPrice(50);
		vest.setWeight(3);

		//Vendors
		Vendor kitchenVendor = new Vendor();
		kitchenVendor.getStuff().put(hp1.getName().toLowerCase(), hp1);
		kitchenVendor.getStuff().put(ag1.getName().toLowerCase(), ag1);
		kitchenVendor.getStuff().put(st1.getName().toLowerCase(), st1);
		kitchenVendor.getStuff().put(plate.getName().toLowerCase(), plate);
		kitchenVendor.getStuff().put(basicSword.getName().toLowerCase(), basicSword);
		kitchen.setVendor(kitchenVendor);
		
		Vendor libraryVendor = new Vendor();
		libraryVendor.getStuff().put(hp2.getName().toLowerCase(), hp2);
		libraryVendor.getStuff().put(ag2.getName().toLowerCase(), ag2);
		libraryVendor.getStuff().put(robe.getName().toLowerCase(), robe);
		libraryVendor.getStuff().put(kite.getName().toLowerCase(), kite);
		library.setVendor(libraryVendor);
		
		Vendor gardenVendor = new Vendor();
		gardenVendor.getStuff().put(hp3.getName().toLowerCase(), hp3);
		gardenVendor.getStuff().put(st2.getName().toLowerCase(), st2);
		gardenVendor.getStuff().put(vest.getName().toLowerCase(), vest);
		gardenVendor.getStuff().put(buckler.getName().toLowerCase(), buckler);
		gardenVendor.getStuff().put(dagger.getName().toLowerCase(), dagger);

		garden.setVendor(gardenVendor);
		
		//NPC
		Character hallNPC = new Character("Guard");
		hallNPC.setAgility(1);
		hallNPC.setGold(40);
		hallNPC.setLifePoints(80);
		hallNPC.setMaxLifePoints(80);
		hallNPC.setStrength(20);
		
		Character firstBdNPC = new Character("Guard");
		firstBdNPC.setAgility(15);
		firstBdNPC.setGold(60);
		firstBdNPC.setLifePoints(100);
		firstBdNPC.setMaxLifePoints(100);
		firstBdNPC.setStrength(30);
		
		Character secondBdNPC = new Character("Guard");
		secondBdNPC.setAgility(10);
		secondBdNPC.setGold(70);
		secondBdNPC.setLifePoints(100);
		secondBdNPC.setMaxLifePoints(100);
		secondBdNPC.setStrength(40);
		
		Character libraryNPC = new Character("Librarian");
		libraryNPC.setAgility(5);
		libraryNPC.setGold(70);
		libraryNPC.setLifePoints(120);
		libraryNPC.setMaxLifePoints(120);
		libraryNPC.setStrength(30);
		
		Character boss = new Character("BOSS");
		boss.setAgility(40);
		boss.setGold(300);
		boss.setLifePoints(250);
		boss.setMaxLifePoints(250);
		boss.setStrength(50);
		

		//Location Items
		startUp.setItem(hp4);
		bath.setItem(hp5);
		cellar.setItem(spear);
		garret.setItem(sword);
		firstBedroom.setItem(st3);
		bedroomHall.setItem(ag3);
		
		//Location NPC
		entranceHall.setNpc(hallNPC);
		firstBedroom.setNpc(firstBdNPC);
		secondBedroom.setNpc(secondBdNPC);
		library.setNpc(libraryNPC);
		secretPassage.setNpc(boss);
		
		
	}

	public Player createMainCharacter(String name) {
		Player player = new Player(name);
		player.setAgility(15);
		player.setGold(70);
		player.setLifePoints(300);
		player.setMaxLifePoints(300);
		player.setStrength(20);
		player.setMaxWeight(20);
		
		return player;
	}
}
