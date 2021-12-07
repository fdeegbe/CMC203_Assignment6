import static org.junit.Assert.assertTrue;

public class test {

    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);
        bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);
        bevShop.startNewOrder(12,DAY.SATURDAY,"Amy", 43);

        bevShop.sortOrders();

        System.out.println(bevShop.getOrderAtIndex(0).random);
        System.out.println(bevShop.getOrderAtIndex(1).random);
        System.out.println(bevShop.getOrderAtIndex(2).random);

        System.out.println(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo());
        System.out.println(bevShop.getOrderAtIndex(1).getOrderNo()< bevShop.getOrderAtIndex(2).getOrderNo());
    }
}