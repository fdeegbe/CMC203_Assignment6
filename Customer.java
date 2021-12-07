
public class Customer {
	String name;
	int age;
	/**
	 * returns the age of the customer
	 * @return the customer's age
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the name of the Customer
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns the age of the customer
	 * @return the Customer's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * sets the age of the customer
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Parameterized constructor
	 * @param name
	 * @param age
	 */
	//constructor
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	//copy constructor
	/**
	 * Parameterized constructor 
	 * @param c - Customer object
	 */
	public Customer(Customer c)
	{
		name = c.name;
		age = c.age;
	}
	/**
	 * Overriden toString method
	 */
	@Override
	public String toString()
	{
		return "\nName: " + getName() +
				"\nAge: " + getAge();
	}
}
