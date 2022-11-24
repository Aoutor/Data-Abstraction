
import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(){
        amount = 0;
        date = new Date();
        account = "";
    }

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        return "Withdraw of: " + amount + " Date: " + date + " into account: " + account + " Current Balance in " + account + " is: ";
    }
}
