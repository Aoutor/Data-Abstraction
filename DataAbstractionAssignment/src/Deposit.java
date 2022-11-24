
import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(){
        amount = 0;
        date = new Date();
        account = "";
    }
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        return "Deposit of: " + amount + " Date: " + date + " into account: " + account + " Current Balance in " + account + " is: ";
    }
}
