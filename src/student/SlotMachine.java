package student;
import framework.SimpleIO;
import java.util.Random;

public class SlotMachine {
    
    private double amount;
    
    public SlotMachine() {
        this.amount = 100;
    }
    
    public double play() {
        Random random = new Random();
        int num = random.nextInt(100);
        if (num < 95) 
            return 0;
        int payout = 100-num;
        if (payout > amount)
            return amount;
        return payout;
    }
      
    private final SimpleIO io = new SimpleIO();
}
