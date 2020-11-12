package mazegame.entity;

import java.util.Random;

public class Dice {
	private int startVal;
	private int endVal;
	private Random r = new Random();
	
	public Dice() {
		setStartVal(1);
		setEndVal(6);
	}
	
	public Dice(int startVal, int endVal) {
		setStartVal(startVal);
		setEndVal(endVal);
	}
	
	public int getStartVal() {
		return startVal;
	}
	public void setStartVal(int startVal) {
		this.startVal = startVal;
	}
	public int getEndVal() {
		return endVal;
	}
	public void setEndVal(int endVal) {
		this.endVal = endVal;
	}
	
	public int roll() {
		int result = r.nextInt(endVal + 1 - startVal) + startVal;
		return result;
	}
	
}
