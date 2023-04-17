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
        amount += 0.25;
        if (num < 95) 
            return 0;
        double payout = 100-num;
        if (payout > amount)
            payout = amount;
        amount -= payout; 
        return payout;
    }
      
    private final SimpleIO io = new SimpleIO();
}
