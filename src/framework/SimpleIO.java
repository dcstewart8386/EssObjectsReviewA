
package framework;

public class SimpleIO {

    public void write(String output) {
        System.out.println(output);
        Framework.addOutputLine(output);
    }
    
    public void write(int output) {
        write(""+output);
    }

    public void write(double output) {
        write(""+output);
    }
    
    public void write(boolean output) {
        write(""+output);
    }

    public void write(char output) {
        write(""+output);
    }
    
    public String readString() {
        String value = Framework.getNextInput();
        System.out.println("\u001B[34m" + value + "\u001B[31m");
        return value;
    }
    
    public int readInt() {
        String str = readString();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            Framework.reportError("Could not convert input to integer.");
            return 0;
        }
    }
    
    public double readDouble() {
        String str = readString();
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            Framework.reportError("Could not convert input to double.");
            return 0;
        }
    }
    
    public boolean readBoolean() {
        String str = readString();
        if (str.trim().equalsIgnoreCase("true"))
            return true;
        if (str.trim().equalsIgnoreCase("false"))
            return false;
      
        Framework.reportError("Could not convert input to boolean.");
        return false; // Should never get here
    }
    
    public char readChar() {
        String str = readString().trim();
        if (str.length() != 1)
            Framework.reportError("Could not convert input to char.");
        return str.charAt(0);
    }
}
