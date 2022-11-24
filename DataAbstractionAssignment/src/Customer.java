
import java.util.ArrayList;
import java.util.Date;




public class Customer {

    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer() {
        /*
        (Side note)
        I made the customer starts with no money, but you can start with money by changing the default constructor below
        */
        name = "Alex";
        accountNumber = 1195577;
        checkBalance = 0;  //  <---- Change for starting money
        savingBalance = 0; //  <---- Change for starting money
        savingRate = 0;
    }

    Customer(String name, int accountNumber, double checkBalance, double savingBalance, double savingRate) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
        this.savingRate = savingRate;
    }

    /*
    Requires: double, date, string
    Modifies: this, deposits
    Effects: Creates new element in arraylist and adds amount to balance
    */
    public double deposit(double amt, Date date, String account) {
        if (account.equals(CHECKING)){
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account));
            return checkBalance;
        } else if (account.equals(SAVING)){
            savingBalance += amt;
            deposits.add(new Deposit(amt, date, account));
            return savingBalance;
        } else {
            System.out.println("Choose Checking or Saving (Case sensitive)");
            return 0;
        }
    }


    /*
    Requires: double, date, string
    Modifies: this, deposits
    Effects: Creates new element in arraylist and removes amount from balance
    */
    public double withdraw(double amt, Date date, String account){
        if (account.equals(CHECKING) && checkOverdraft(amt)){
            checkBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account));
            return checkBalance;
        } else if (account.equals(SAVING)  && checkOverdraft(amt)){
            savingBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account));
            return savingBalance;
        } else if (!checkOverdraft(amt)){
            System.out.println("overdraft");
            return 0;
        } else {
            return 0;
        }
    }


    /*
    Requires: double
    Modifies: this
    Effects: Returns a true or false value
    */
    private boolean checkOverdraft(double amt) {
        /*
        I don't really know what overdraft means, but I took a guess and assumed it's like a withdrawal limit of some sort ??
        Anyway, I made it so if you withdraw over 100 dollars you hit overdraft because that's what it's value was set originally. Hope this is ok.
         */

        if (-amt < OVERDRAFT){
            return false;
        } else {
            return true;
        }
    }


    /*
    Requires: string
    Modifies: this
    Effects: Prints element in arraylist
    */
    public void displayDeposits(String account) {
        if (account.equals(CHECKING)){
            for (Deposit d : deposits) {
                System.out.println(d + "" + checkBalance);
            }
        } else if (account.equals(SAVING)){
            for (Deposit d : deposits) {
                System.out.println(d + "" + savingBalance);
            }
        }
    }

    /*
    Requires: string
    Modifies: this
    Effects: Prints element in arraylist
    */
    public void displayWithdraws(String account) {
        if (account.equals(CHECKING)){
            for (Withdraw w : withdraws) {
                System.out.println(w + "" + checkBalance);
            }
        } else if (account.equals(SAVING)){
            for (Withdraw w : withdraws) {
                System.out.println(w + "" + savingBalance);
            }
        }
    }
}

