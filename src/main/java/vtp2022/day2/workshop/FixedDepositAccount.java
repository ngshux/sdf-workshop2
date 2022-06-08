package vtp2022.day2.workshop;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3;
    private int duration = 6;
    Boolean interestChanged = false;
    Boolean durationChanged = false;

    public FixedDepositAccount (String name, float initialBal){
        super(name, initialBal);
    }

    public FixedDepositAccount (String name, float initialBal, float interest){
        super(name, initialBal);
        this.interest = interest;
    }
    public FixedDepositAccount (String name, float initialBal, float interest,
                                int duration){
        super(name, initialBal);
        this.interest = interest;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <0){
            throw new IllegalArgumentException("Unsupported duration");
        }
        else if (!durationChanged){
            this.duration = duration;
            durationChanged = true;
        }
        else
            throw new IllegalArgumentException("Only can set duration once.");  
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        if (interest <0){
            throw new IllegalArgumentException("Unsupported interest value");
        }
        else if (!interestChanged){
            this.interest = interest;
            interestChanged = true;
        }
        else
            throw new IllegalArgumentException("Only can set interest once.");  
    }

    @Override
    public void deposit(String depositAmt){
    }

    @Override
    public float withdraw(String withdrawAmt){
        return 0;
    }

    @Override
    public float getBalance(){
        return super.getBalance() + interest;
    }
}
