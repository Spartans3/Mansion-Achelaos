package mazegame.entity;

import java.util.HashMap;

public class Character {
	private int agility;
    private int lifePoints;
    private String name;
    private int strength;
    private Dice dice = new Dice();
    private Shield shield;
    private Weapon weapon;
    private Armor armor;
    private int maxLifePoints;
    private int gold;
    private int maxWeight;
    private HashMap<String,Item> items;
    private int currentWeight;
    private int blockChance;
    
    
    public Character()
    {
    	items = new HashMap<String,Item>();
    }

    public Character(String name)
    {
    	items = new HashMap<String,Item>();
        this.setName(name);
    }
    
    public int swingAttack() {
    	int baseDmg = (int)(getStrength()*(80f/100.0f));
    	if(dice.roll() > 5)
    		baseDmg += baseDmg + (int)(getAgility()*(30f/100.0f));
    	
    	return baseDmg;
    }
    
    public int stabAttack() {
    	int baseDmg =(int)(getStrength()*(60f/100.0f));
    	
    	if(dice.roll() > 4)
    		baseDmg += baseDmg + (int)(getAgility()*(80f/100.0f));
    	
    	return baseDmg;
    }
    
    public boolean reflectDamage() {
    	if(getShield() == null)
    		return false;
    	
    	Dice blockDice = new Dice(1, 100);
    	int rolledNum = blockDice.roll();
    	
    	if(getShield().getBlockChance() + (int)(getAgility()*(50f/100.0f)) > rolledNum)
    		return true;
    	else
    		return false;
    	
    }

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		if(lifePoints<0)
			lifePoints = 0;
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getMaxLifePoints() {
		return maxLifePoints;
	}

	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public HashMap getItems() {
		return items;
	}

	public void setItems(HashMap items) {
		this.items = items;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public int getBlockChance() {
		return blockChance;
	}

	public void setBlockChance(int blockChance) {
		this.blockChance = blockChance;
	}
}
