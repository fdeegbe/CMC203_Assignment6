
public class Alcohol extends Beverage {
	boolean isOffered = false;
	/**
	 * Parameterized constructor
	 * @param name
	 * @param size
	 * @param offer
	 */
	public Alcohol(String name, SIZE size, boolean offer) {
		super(name, TYPE.ALCOHOL, size);
		isOffered = offer;
	}
	/**
	 * return the value of isOffered 
	 * @return isOffered
	 */
	public boolean isOffered() {
		return isOffered;
	}
	/**
	 * set the value of isOffered
	 * @param isOffered
	 */
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	/**
	 * calculates the price of the beverage
	 * @return the cost
	 */
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
		if(isOffered)
		{
			price += 0.60;
		}
		return price;
	}
	/**
	 * overriden equals method comparing the isOffered field
	 * @param a - an alcohol object
	 * @return true if equals, false if not
	 */
	public boolean equals(Alcohol a)
	{
		return super.equals(a) && isOffered() == a.isOffered();
	}
	/**
	 * overriden toString method
	 */
	public String toString()
	{
		return super.toString() +
				"\nOffered on the weekends: " + isOffered() +
				"\nPrice: $" + calcPrice();

	}

}
