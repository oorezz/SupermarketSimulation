package Supermarket;

// Kunde er i butikken
// Kunde har plukket varer
// Kunde er i kasse køen
// Kunde er ut av butikken



import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Test {

    //Køene er lagt ved hjelp av klassen Queue som tar imot Customer objekter.
    static Queue<Customer> kasse1 = new LinkedList<Customer>();
    static Queue<Customer> kasse2 = new LinkedList<Customer>();

    //int som lagrer tiden brukt i kassen for hver Customer
    static int durationKasse1;
    static int durationKasse2;

    public static void main(String[] args) throws InterruptedException {

        //For-løkke som genererer gitt antall customers og printer ut deres informasjon.
        for (int i = 1; i < 6; i++){
            Customer customer = new Customer();
            System.out.println("---------------------------------------------");
            System.out.println("Your customer id is: " + customer.getCustomerID());
            System.out.println("You have this many items: " + customer.getNumOfItems());
            System.out.println("You entered the shop when time was: " + customer.getBeginShoppingTime());
            System.out.println("---------------------------------------------");

//            Thread.sleep(1000);

            //if statement som hjelper med å sende inn kunder til en av 2 kassene basert på trafikk.
            //og hvis kundene har o blir kunden ikke sendt til noen av kassene.
            if (customer.getNumOfItems() != 0) {
                if (kasse1.size() > kasse2.size()) {
                    kasse2.add(customer);
                } else {
                    kasse1.add(customer);
                }
            }
        }

//        Thread.sleep(2000);

        //Print ut antall kunder på de 2 kassene.
        System.out.println("---------------------------------------------");
        System.out.println("Kasse1 kø: "+ kasse1.size() + " - " + kasse1);
        System.out.println("Kasse2 kø: "+ kasse2.size() + " - " + kasse2);
        System.out.println("---------------------------------------------");

//        Thread.sleep(2000);

        //For hver customer i kasse1 lagre tiden brukt for å betale og det er antall varer * 20
        //
            for (Customer customer : kasse1) {
                customer.payingDuration = customer.getNumOfItems() * 20;
                System.out.println("----------------- Kasse 1 -------------------");
                durationKasse1 = customer.payingDuration + durationKasse1;
                System.out.println("Customer was in queue for "+ durationKasse1 +" time");

                //Hvis det er fortsatt kunder i kassen
                if (kasse1.size() > 0) {
                    System.out.println(customer.getCustomerID() + " finished paying in: " + customer.payingDuration);
                    System.out.println("---------------------------------------------");
                }else {
                    kasse1.poll();
                }
            }

        //  Thread.sleep(2000);
            for (Customer customer : kasse2) {
                customer.payingDuration = customer.getNumOfItems() * 20;
                System.out.println("----------------- Kasse 2 -------------------");
                durationKasse2 = customer.payingDuration + durationKasse2;
                System.out.println("Customer was in queue for "+ durationKasse2 +" time");

                //
                if (kasse2.size() > 0) {
                    System.out.println(customer.getCustomerID() + " finished paying in: " + customer.payingDuration);
                    System.out.println("---------------------------------------------");
                }else {
                    kasse2.poll();
                }
            }


    }


}
