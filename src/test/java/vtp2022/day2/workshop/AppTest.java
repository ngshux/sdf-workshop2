package vtp2022.day2.workshop;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vtp2022.day2.workshop.BankAccount;
import vtp2022.day2.workshop.FixedDepositAccount;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        BankAccount bkAcc = new BankAccount("My Account");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("500");
        assertEquals(500,finalBalance,.1);
    }

    @Test
    public void testFixedDepositAccountChangeInterestAndDuration(){
        try{
            FixedDepositAccount fdAcc = 
                new FixedDepositAccount("My FD acc", 10000);

            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setDuration(3);
            fdAcc.setInterest(2);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            //fdAcc.setDuration(7);
            //fdAcc.setInterest(4);
        }catch(IllegalArgumentException e){
            assertTrue("Only can set duration and interest once.".contains(e.getMessage()));
        }
     }
}
