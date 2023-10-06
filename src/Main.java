public class Main {
    public static void main(String[] args) {
        HDFC_ACCOUNT Naveen = new HDFC_ACCOUNT("Naveen","1234",1000);
        System.out.println(Naveen);

        System.out.println(Naveen.fetchBalance("random"));  // wrong password
        System.out.println(Naveen.fetchBalance("1234"));  //correct password

        // add money
        System.out.println(Naveen.addMoney(100000));

        // withdraw
        System.out.println(Naveen.withDrawMoney(200000,"1234"));
        System.out.println(Naveen.withDrawMoney(50000,"1234"));
        System.out.println(Naveen.withDrawMoney(50000,"random"));


        // change Password
        System.out.println(Naveen.changePassword("1234","123245"));
        System.out.println(Naveen.fetchBalance("12345"));

        //calculate interest
        System.out.println("Interest for 5 years on current balance will be: " + Naveen.calculateInterest(5));
    }
}