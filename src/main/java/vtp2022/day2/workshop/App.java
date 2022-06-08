package vtp2022.day2.workshop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - BangBank" );
        BankAccount bankAcc = new BankAccount ("My Account");
        bankAcc.deposit("3");
        System.out.println("New Balance: "+ bankAcc.getBalance());
    }
}
