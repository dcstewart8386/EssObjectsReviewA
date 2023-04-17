package framework;
import java.util.ArrayList;
import java.util.List;
import student.*;

public class Framework {
    
    public static void main(String[] args) {
        inputs = new String[RunConfig.inputFiles.length][];
        
        for (int i = 0; i < RunConfig.inputFiles.length; i++) {
            FileReader fr = new FileReader(RunConfig.inputFiles[i]);
           
            String[] lines = fr.getLines();
            inputs[i] = new String[lines.length];
            for (int j = 0; j < lines.length; j++) {
                inputs[i][j] = lines[j];
            }
            
            System.out.println("\u001b[35m-------------------------------------");
            System.out.println("\u001B[35mRUNNING TEST INPUT FILE: "+RunConfig.inputFiles[i]);
            System.out.println("\u001B[35m-------------------------------------\u001B[0m");
            curOutputLines.clear();
            new Main();
            if (RunConfig.runTests) {
                validateOutput();
            }
            curFileIndex++;
            curLineIndex = 0;
        }
    }
    
    private static void validateOutput() {
        if (curFileIndex >= RunConfig.expectedOutputFiles.length)
            return;
        FileReader fr = new FileReader(RunConfig.expectedOutputFiles[curFileIndex]);
        String[] expectedLines = fr.getLines();
        String[] foundLines = new String[curOutputLines.size()];
        curOutputLines.toArray(foundLines);
        if (expectedLines.length != foundLines.length) {
            reportError("Expected "+expectedLines.length+" of output but received "+foundLines.length+" lines.");
        }
        for (int i = 0; i < expectedLines.length; i++) {
            if (!expectedLines[i].trim().equalsIgnoreCase(foundLines[i].trim())) {
                String msg = "Test data mistmatch on line "+(i+1)+" of \""+RunConfig.expectedOutputFiles[curFileIndex]+"\"";
                msg += "\n   \u001b[31mExpected: "+expectedLines[i];
                msg += "\n   \u001b[31mReceived: "+foundLines[i];
                reportError(msg);
            }
                
        }
    }
    
    public static String getNextInput() {
        if (curLineIndex >= inputs[curFileIndex].length) {
            reportError("No input left to read in test file");
            return "";
        }
        return inputs[curFileIndex][curLineIndex++];
    }
    
    public static void addOutputLine(String line) {
        curOutputLines.add(line);
    }
    
    public static void reportError(String msg) {
        System.out.println("\u001b[31mERROR - "+msg);
        System.exit(0);
    }
    
    private static String[][] inputs;
    private static int curFileIndex = 0;
    private static int curLineIndex = 0;
    private static List<String> curOutputLines = new ArrayList<String>();
    
}
