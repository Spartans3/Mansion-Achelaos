package mazegame.entity;

public class AgilityPotion extends Item{

	public AgilityPotion() {
		setName("AgilityPotion");
		Dice dice = new Dice(1,15);
		int firstDice = dice.roll();
		setAgility(firstDice);
		setPrice(25);
		setWeight(2);
	}

}
