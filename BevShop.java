import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	int nextOrder = -1;
	int maxOrderForAlcohol;
	ArrayList<Order> orderList = new ArrayList<Order>();
	int minAgeForAlcohol;
	/**
	 * Nonparameterized constructor
	 */
	public BevShop() {

		maxOrderForAlcohol = 3;
		minAgeForAlcohol = 21;


	}


	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time) {

		return (time >= 8 && time < 24) ;
	}
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore() {
		if (getNumOfAlcoholDrink() >= 3)
			return false;
		else
			return true;
	}
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public boolean validAge(int age) {
		if(age >= getMinAgeForAlcohol())
			return true;
		else
			return false;
	}
	/**
	 * Creates a new order ,  NO BEVERAGE is added to the order yet 
	 * @param time time of the order  
	 * @param day day of the order of type DAY
	 * @param customerName customer name 
	 * @param customerAge customer age
	 */

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		nextOrder++;
		orderList.add(new Order(time, day, new Customer(customerName, customerAge), false));

	}
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orderList.get(nextOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);

	}
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		orderList.get(nextOrder).addNewBeverage(bevName, size);

	}
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orderList.get(nextOrder).addNewBeverage(bevName, size, numOfFruits, addProtien);

	}
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo) {
		int f = -1;
		for(int i = 0; i < orderList.size(); i++)
		{
			if(orderList.get(i).orderNumber == orderNo)
				f = i;

		}
		return f;
	}
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		double t = 0;
		for(int i = 0; i < orderList.get(orderNo).bevList.size(); i++)
		{
			t = orderList.get(orderNo).calcOrderTotal();
		}
		return t;
	}
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale() {
		double t = 0;
		for(int i = 0; i < orderList.size(); i++)
		{
			t += totalOrderPrice(i);
		}
		return t;
	}
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	@Override
	public void sortOrders() {

		for (int i = 0; i < orderList.size(); i++) 
		{
			int pos = i;
			for (int j = i; j < orderList.size(); j++) {
				if(orderList.get(j).random < orderList.get(pos).random) {
					pos = j;
				}
				Order min = orderList.get(pos);
				orderList.set(pos, orderList.get(i));
				orderList.set(i, min);
			}

		}



	}
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index) {

		return orderList.get(index);
	}
	/**
	 * returns the maximum amount of orders for alcoholic drinks
	 * @return
	 */
	public int getMaxOrderForAlcohol() {
		return maxOrderForAlcohol;
	}

	/**
	 * sets the maximum amount of orders for alcoholic drinks
	 * @param maxOrderForAlcohol
	 */

	public void setMaxOrderForAlcohol(int maxOrderForAlcohol) {
		this.maxOrderForAlcohol = maxOrderForAlcohol;
	}

	/**
	 * returns the minimum age required to have an alcoholic drink
	 * @return
	 */

	public int getMinAgeForAlcohol() {
		return minAgeForAlcohol;
	}


	/**
	 * sets the minimum age required to have an alcoholic drink
	 * @param minAgeForAlcohol
	 */
	public void setMinAgeForAlcohol(int minAgeForAlcohol) {
		this.minAgeForAlcohol = minAgeForAlcohol;
	}


	/**
	 * overriden toString method
	 */
	public String toString() 
	{
		String line = "";
		for(int j = 0; j < orderList.size(); j++){
			for(int i = 0; i < orderList.get(j).bevList.size(); i++)
			{
				line += orderList.get(j).bevList.get(i).toString();
			}
		}
		return line + "\nTotal Monthly sale: " + totalMonthlySale();
	}

	/**
	 * returns the current order
	 * @return the current order
	 */
	public Order getCurrentOrder() {

		return orderList.get(nextOrder);
	}

	/**
	 * returns the number of alcoholic drinks
	 * @return the number of alcoholic drinks
	 */

	public int getNumOfAlcoholDrink() {
		return orderList.get(nextOrder).findNumOfBeveType(TYPE.ALCOHOL);
	}

	/**
	 * returns true or false based on whether or not the user has the maximum amount of fruits in their smoothie
	 * @param numOfFruits
	 * @return return true if the maximum amount of fruits is reached, false otherwise
	 */

	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits >= 6)
			return true;
		else
			return false;
	}

}


