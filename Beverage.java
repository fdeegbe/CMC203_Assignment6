
public abstract class Beverage {
	String beverageName;
	TYPE beverageType;
	SIZE size;
	static final double BASEPRICE = 2.0, SIZEPRICE = 1.0;
/**
 * returns the base price for a beverage
 * @return the base price for a beverage
 */
	public static double getBasePrice() {
		return BASEPRICE;
	}
/**
 * returns the price of a size-up
 * @return the price of a size-up
 */
	public static double getSizePrice() {
		return SIZEPRICE;
	}
/**
 * returns the beverage name
 * @return the beverage name
 */
	public String getBevName() {
		return beverageName;
	}
/**
 * sets the beverage name
 * @param beverageName - the name of the beverage you would like to set
 */
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}
/**
 * returns the type of beverage
 * @return the type of beverage
 */
	public TYPE getBeverageType() {
		return beverageType;
	}
/**
 * sets the beverage type
 * @param beverageType - the beverage type you would like to set
 */
	public void setBeverageType(TYPE beverageType) {
		this.beverageType = beverageType;
	}
/**
 * returns the size of the beverage
 * @return the beverage size
 */
	public SIZE getSize() {
		return size;
	}
/**
 * sets the size of the beverage
 * @param size - the beverage size
 */
	public void setSize(SIZE size) {
		this.size = size;
	}
/**
 * parameterized constructor
 * @param name
 * @param type
 * @param size
 */
	//constructor
	public Beverage(String name,TYPE type,SIZE size)
	{
		beverageName = name;
		beverageType = type;
		this.size = size;
	}
/**
 * calculates the price of a singular beverage
 * @return the total price of the beverage
 */
	//abstract methods
	abstract double calcPrice();
	//toString
	/**
	 * overridden toString method
	 */
	@Override
	public String toString() 
	{
		return "Beverage: " + getBevName() +
				"\nBeverage type: " + beverageType.toString() +
				"\nSize: " + getSize().toString();
	}
	/**
	 * compares the name of the beverages, the type, and the size and returns true or false based on the results
	 * @param b - the beverage object being compared
	 * @return - true if both beverages are equal, false otherwise
	 */
	public boolean equals(Beverage b)
	{
		return (beverageName.equals(b.beverageName) && beverageType == b.beverageType && size == b.size );
	}
	//	Redundant method for the Junit test
	/**
	 * redundant method for the Junit test
	 * @return the beverage type 
	 */
	public Object getType() {
		return beverageType;
	}

}
