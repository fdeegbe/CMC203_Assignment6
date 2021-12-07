import java.util.ArrayList;
import java.util.Random;
public class Order extends Customer implements OrderInterface, Comparable {
	static int orderNumber = -1;
	int random = rand();
	int time = 0;
	//double orderTime;
	DAY day;
	TYPE[] bevTypeList = {TYPE.COFFEE, TYPE.SMOOTHIE, TYPE.ALCOHOL}; 
	boolean weekend = false;

	ArrayList<Beverage> bevList = new ArrayList<Beverage>();

	/**
	 * Parameterized constructor
	 * @param time
	 * @param day
	 * @param c - Customer object
	 * @param b - isWeekend
	 */
	public Order(int time, DAY day, Customer c, boolean b) {
		super(c);
		orderNumber++;
		this.day = day;
		if(isWeekend()) {
			weekend = true;
		}

	}
	/**
	 * returns the order number
	 * @return the order number
	 */
	public int getOrderNo() {
		return orderNumber;
	}
	/**
	 * sets the order number
	 * @param orderNumber - the order number 
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * sets the day
	 * @return the day
	 */
	public DAY getDay() {
		return day;
	}
	/**
	 * sets the day
	 * @param day
	 */
	public void setDay(DAY day) {
		this.day = day;
	}
	/**
	 * returns the beverage list
	 * @return the beverage list
	 */
	public ArrayList<Beverage> getBevList() {
		return bevList;
	}
	/**
	 * sets the beverage list
	 * @param bevList - the beverage list
	 */
	public void setBevList(ArrayList<Beverage> bevList) {
		this.bevList = bevList;
	}
/**
 * Parameterized constructor
 * @param orderNumber - the order number
 * @param day - the day
 * @param c - customer object
 */
	public Order(int orderNumber, DAY day, Customer c)
	{
		super(c);
		bevList = new ArrayList<Beverage>();
		this.orderNumber = orderNumber;
		this.day = day;
		if(isWeekend()) {
			weekend = true;
		}

	}

/**
 * returns a random value
 * @return a random value
 */
	public int rand()
	{
		return new Random().nextInt(90000 - 10000) + 10000;
	}
	/**
	 * compares the ordernumber of a set order object
	 */
	@Override
	public int compareTo(Object o) {

		if(((Order)o).getOrderNo() == getOrderNo())
		{
			return 0;
		}
		else if( ((Order) o).getOrderNo() > getOrderNo())
		{
			return -1;
		}
		else
			return 1;

	}
/**
 * return true if the day falls on the weekend, false otherwise
 * @return true if weekend, false otherwise
 */
	@Override
	public boolean isWeekend() {
		boolean c = false;
		switch(day)
		{
		case FRIDAY:
			break;
		case MONDAY:
			break;
		case SATURDAY:
			c = true;
			break;
		case SUNDAY:
			c = true;
			break;
		case THURSDAY:
			break;
		case TUESDAY:
			break;
		case WEDNESDAY:
			break;
		default:
			break;

		}
		return c;
	}
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		return bevList.get(itemNo);
	}
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));

	}
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void addNewBeverage(String bevName, SIZE size) {

		bevList.add(new Alcohol(bevName, size, weekend));

	}
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		bevList.add(new Smoothie(bevName, size, numOfFruits, addPRotien));

	}
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			total += bevList.get(i).calcPrice();
		}
		return total;
	}
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		int counter = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			if(bevList.get(i).getBeverageType() == type)
			{
				counter++;
			}
		}
		return counter;
	}
/**
 * returns the current customer
 * @return the customer object
 */
	public Customer getCustomer() {
		return new Customer(getName(), getAge());
	}
/**
 * Parameterized toString constructor
 */
	public String toString()
	{
		String line = "";
		for(int i = 0; i < bevList.size(); i++)
		{
			line += bevList.get(i).toString();
		}
		return super.toString() + 
				"\nDay: " + getDay().toString() +
				"\nOrder Number: " + getOrderNo() +
				"\nDrinks Purchased: " + bevList.size() + 
				"\nOrder List: " + line +
				"\nTotal: " + calcOrderTotal();


	}
/**
 * returns the size of the order list
 * @return the number of beverages
 */
	public int getTotalItems() {
		return bevList.size();
	}



}
