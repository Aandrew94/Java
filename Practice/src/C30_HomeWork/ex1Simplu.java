package C30;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex1Simplu {
    public static void  main(String[] args) throws FileNotFoundException {
        List<String> getInfo = new ArrayList<>();
        List<String> newInfo = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("TextInput.txt"));
            while(scanner.hasNextLine()) {
                getInfo.add(scanner.nextLine());
            }
        } catch(IOException e) {
            System.out.println("Something wrong has happened...");
            e.printStackTrace();
        } finally {
            // Closing the scanner will automatically close the FileReader
            if(scanner != null) {
                scanner.close();
            }
        }


        for(String ss : getInfo){
            String tmp = ss.replace("fotbal","volei");
            newInfo.add(tmp);
        }


/**
 * Write into the file
 */
        FileWriter outputFile = null;
        try {
            outputFile = new FileWriter("TextInput.txt");
            for (String word : newInfo) {
                outputFile.write(word+"\n");
            }


        } catch (IOException e) {
            System.out.println("Something wrong has happened...");
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                System.out.println("Exception raised when attempting to close the file");
                e.printStackTrace();
            }
        }


    }
}
