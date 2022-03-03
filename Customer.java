package Supermarket;

import java.util.Random;

public class Customer {

    int payingDuration;
    int beginShoppingTime;

    Random random = new Random();
    int randomItems = random.nextInt(10);
    int randomTime = random.nextInt(14);

    private static int counter = 1;

    private final String customerID;

    private int numOfItems;


    public Customer() {
        this.customerID = "Cust " + counter;
        this.numOfItems = randomItems;
        this.beginShoppingTime = randomTime;
        counter++;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public int getBeginShoppingTime() {
        return beginShoppingTime;
    }

    @Override
    public String toString(){
        return customerID;
    }
}
