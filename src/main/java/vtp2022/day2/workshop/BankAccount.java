package vtp2022.day2.workshop;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class BankAccount {
    private String name ="";
    private String acctId = UUID.randomUUID().toString().substring(0,8);

    private float balance =0f;
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed =false;
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;
    

    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    
    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public float withdraw(String withdrawalAmt){
        Float withdraw = null;
        try {
                withdraw = Float.parseFloat(withdrawalAmt);
                if(withdraw.floatValue() <= 0){
                    throw new IllegalArgumentException("Amount cannot be negative or 0");
                }
                if(this.isClosed){
                    throw new IllegalArgumentException("Invalid account");
                }

                if(withdraw.floatValue() <= this.balance){
                    this.balance -= withdraw.floatValue();
                    
                    StringBuilder txnStrbld = new StringBuilder();
                    txnStrbld.append("Withdrew $");
                    txnStrbld.append(withdraw.floatValue());
                    txnStrbld.append(" at ");
                    txnStrbld.append(LocalDateTime.now());

                    System.out.println(txnStrbld.toString());
                    transaction.add(txnStrbld.toString());
                }
                else
                    throw new IllegalArgumentException("Insufficient Balance");


        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }

        return withdraw.floatValue();
    }

    public void deposit (String depositAmt){
        try {
                Float deposit = Float.parseFloat(depositAmt);
                if(deposit.floatValue() <= 0){
                    throw new IllegalArgumentException("Amount cannot be negative or 0");
                }
                if (this.isClosed){
                    throw new IllegalArgumentException("Invalid account");
                }

                this.balance += deposit.floatValue();

                StringBuilder txnStrbld = new StringBuilder();
                txnStrbld.append("Deposited $");
                txnStrbld.append(deposit.floatValue());
                txnStrbld.append(" at ");
                txnStrbld.append(LocalDateTime.now());

                System.out.println(txnStrbld.toString());
                transaction.add(txnStrbld.toString());


        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }
}
