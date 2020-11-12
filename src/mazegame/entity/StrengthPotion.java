package mazegame.entity;

public class StrengthPotion extends Item{

	public StrengthPotion() {
		setName("StrengthPotion");
		Dice dice = new Dice(1,15);
		int firstDice = dice.roll();
		setStrength(firstDice);
		setPrice(25);
		setWeight(1);
	}

}
