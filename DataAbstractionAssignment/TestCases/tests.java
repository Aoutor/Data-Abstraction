import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class tests {
    Customer testSet;
    Deposit testSetd;
    Withdraw testSetw;

    @Before
    public void setup(){
        testSet = new Customer();

        testSetd = new Deposit();
        testSetw = new Withdraw();
    }

    /*

    Hello teacher. For these tests I could not insert an expected value because the output for my methods fetches
    values from a scanner. Depending on what the user types in the console, each method will return a different output.

    Example: User types "$400",   Output: $400 deposited to Checking
             User types "$35",    Output: $35 deposited to Checking

    That said, I laid out the tests below. Assuming the methods didn't take in values from a scanner and instead always returned one specific output
    it could be compared to an expected output and would return true.

    */

    @Test
    public void test1(){
        assertEquals(" Read comment above ", testSet.deposit(400, new Date(), Customer.CHECKING)); //Test for deposit method
    }
    @Test
    public void test2(){
        assertEquals(" Read comment above ", testSet.withdraw(400, new Date(), Customer.CHECKING)); //Test for withdraw method
    }
    @Test
    public void test3(){
        assertEquals(" Read comment above ", testSetd.toString()); //Test for deposit toString method
    }
    @Test
    public void test4(){
        assertEquals(" Read comment above ", testSetw.toString()); //Test for withdraw toString method
    }
}
