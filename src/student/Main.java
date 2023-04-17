package student;
import framework.SimpleIO;

public class Main {
       
    public Main() {
        SlotMachine machine = new SlotMachine();
        
        double money = 50;
        for (int i = 0; i < 30; i++) {
            money -= 0.25;
            
            double payout = machine.play();
            money += payout;
            io.write("Payout: "+payout+", Balance: "+money);
        }
        
    }
    
    private final SimpleIO io = new SimpleIO();
}
