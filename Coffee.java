
public class Coffee extends Beverage{
	boolean containsExtraCoffee = false, containsExtraSyrup;

	public Coffee(String name, SIZE size, boolean extraCoffee, Boolean extraSyrup)
	{
		super(name, TYPE.COFFEE, size);
		containsExtraCoffee = extraCoffee;
		containsExtraSyrup = extraSyrup;
	}



	public boolean isContainsExtraCoffee() {
		return containsExtraCoffee;
	}



	public void setContainsExtraCoffee(boolean containsExtraCoffee) {
		this.containsExtraCoffee = containsExtraCoffee;
	}



	public boolean isContainsExtraSyrup() {
		return containsExtraSyrup;
	}



	public void setContainsExtraSyrup(boolean containsExtraSyrup) {
		this.containsExtraSyrup = containsExtraSyrup;
	}



	@Override
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
		if(isContainsExtraCoffee())
			price += .5;
		if(isContainsExtraSyrup())
			price +=.5;

		return price;
	}
	public String toString()
	{
		return super.toString() + "\nExtra coffee: " + isContainsExtraCoffee() +
				"\nExtra syrup: " + isContainsExtraSyrup() +
				"\nPrice: $" + calcPrice();
	}
	public boolean equals(Coffee b)
	{
		return (super.equals(b) &&
				containsExtraCoffee == b.containsExtraCoffee &&
				containsExtraSyrup == b.containsExtraSyrup);
	}



}



