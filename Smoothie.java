
public class Smoothie extends Beverage{
	int numOfFruits = 0;
	boolean proteinPowder = false;
	
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}
	public boolean isProteinPowder() {
		return proteinPowder;
	}
	public void setProteinPowder(boolean proteinPowder) {
		this.proteinPowder = proteinPowder;
	}
	public Smoothie(String name, SIZE size, int fruits, Boolean p)
	{
		super(name, TYPE.SMOOTHIE, size);
		numOfFruits = fruits;
		proteinPowder = p;
		
	}
	public double calcPrice()
	{
		double price = BASEPRICE;
		switch(size)
		{
		case LARGE:
			price += SIZEPRICE;
		case MEDIUM:
			price += SIZEPRICE;
		case SMALL:
		default:
			break;    
		}
		if (proteinPowder)
		{
			price += 1.5;
		}
		return price + (numOfFruits * .5);
	}
	public String toString()
	{
		return super.toString() + 
				"\nProtein Powder: " + isProteinPowder() +
				"\nFruits added: " + getNumOfFruits() +
				"\nPrice: $" + calcPrice();
	}
	public boolean equals(Smoothie s)
	{
		return super.equals(s) 
				&& isProteinPowder() == s.isProteinPowder() 
				&& getNumOfFruits() == s.getNumOfFruits();
	}
}
