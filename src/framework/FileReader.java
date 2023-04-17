/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framework;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.*; // Import the Scanner class to read text files

public class FileReader {

    private List<String> strings = new ArrayList<String>();
    
    public FileReader(String fn) {
        try {
            File myObj = new File("iofiles/"+fn);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                strings.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public String[] getLines() {
        String[] arr = new String[ strings.size() ];
        strings.toArray(arr);
        return arr;
    }

}
