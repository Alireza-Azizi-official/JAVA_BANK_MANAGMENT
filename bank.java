import java.util.Scanner;

public class bank {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerID' to access to your account:");
        String name = sc.nextLine();
        String customerID = sc.nextLine();
        bankaccount obj = new bankaccount(name, customerID);
        obj.menu();
    }
}
class bankaccount{
    double balance;
    double prevTrans;
    String customerName;
    String CustomerId;

    bankaccount(String customerName, String customerId){
        this.customerName = customerName;
        this.CustomerId = customerId;
    }

    double deposit(double amount){
        if( amount != 0){
            balance += amount;
            prevTrans += amount;
            return amount;
        }
        else{
            return 0;
        }
    }

    double withdraw(double amt){
        if(amt != 0 && balance >= amt){
            balance -= amt;
            prevTrans =- amt;
            return amt;
        }
        else if(balance < amt){
            System.out.println("Insufficient Balance");
            return 0;
        }
        else{
            return 0;
        }
    }

    void getPreviousrTrans() {
        if(prevTrans > 0) {
            System.out.println( "Deposited : " + prevTrans);
        }
        else if(prevTrans < 0) {
            System.out.println("Withdrawn : " + Math.abs(prevTrans));
        }
        else {
            System.out.println(" No Transaction.");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Customer ID :" + CustomerId);
        System.out.println("Choose an option:");
        System.out.println("_________________     _________________");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposite Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        do {
            System.out.println("_________________     _________________");
            System.out.println("Choose a number:");
            option = sc.next().charAt(0);

            double amount = 0;
            switch (option) {
                case 'a':
                    System.out.println(".............................");
                    System.out.println("Balance :" + balance);
                    break;

                case 'b':
                    System.out.println(".............................");
                    System.out.println("Enter amount :");
                    amount = sc.nextDouble();
                    amount = deposit(amount);
                    System.out.println(Math.abs(amount) + " added to your balance");
                    System.out.println("The opearation accomplished successfuly");
                    break;

                case 'c':
                    System.out.println(".............................");
                    System.out.println("Enter amount: ");
                    amount = sc.nextDouble();
                    amount = withdraw(amount);
                    System.out.println(Math.abs(amount) + " withdrawn from your account");
                    System.out.println("The opearation accomplished successfuly");
                    break;

                case 'd':
                    System.out.println(".............................");
                    System.out.println("Previous Transation:");
                    getPreviousrTrans();
                    break;

                case 'e':
                    System.out.println(".............................");
                    break;

                default:
                    System.out.println("Choose an option: ");
                    break;
            }
        } while (option != 'e');
        System.out.println("Thank you for using our services.");
    }
}