import java.util.Scanner;
import java.util.Date;

public class main {

    public static void main(String[] args) {
        prompt();
    }

    public static void prompt(){
        /*
        This method displays prompt messages for the user.
        Asks the user how much they want to deposit/withdraw, which account does the user want to use (Checking/Saving), stuff like that.

        Depending on the user's answers, the code will fire specific methods. If the user types "Deposit", the deposit() method will be fired.
        */
        String action;
        String account;
        int money;
        Customer customer = new Customer();
        System.out.println("Do you want to Withdraw or Deposit? (Case sensitive)");
        Scanner scan = new Scanner(System.in);
        action = scan.nextLine();
        if (action.equals("Deposit")){
            System.out.println("Which account do you to want use? Checking or Saving (Case sensitive)");
            account = scan.nextLine();
            System.out.println("How much do you want to deposit?");
            money = Integer.parseInt(scan.nextLine());
            customer.deposit(money, new Date(), account);  // <----- Method for DEPOSIT
            customer.displayDeposits(account);
        } else if (action.equals("Withdraw")){
            System.out.println("Which account do you want to use? Checking or Saving (Case sensitive)");
            account = scan.nextLine();
            System.out.println("How much do you want to withdraw?");
            money = Integer.parseInt(scan.nextLine());
            customer.withdraw(money, new Date(), account);  // <----- Method for WITHDRAW
            customer.displayWithdraws(account);
        }
    }
}