package mazegame.entity;

public class Shield extends Item{
	private int blockChance;
	
	public Shield(String name) {
		setName(name);
	}
	
	public int getBlockChance() {
		return blockChance;
	}
	public void setBlockChance(int blockChance) {
		this.blockChance = blockChance;
	}


}
