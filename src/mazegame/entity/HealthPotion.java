package mazegame.entity;

public class HealthPotion extends Item{

	public HealthPotion() {
		setName("HealthPotion");
		Dice dice = new Dice();
		int firstDice = dice.roll();
		int secondDice = dice.roll();
		setLifePoints((firstDice + secondDice) * 20);
		setPrice(15);
		setWeight(1);
	}

}
