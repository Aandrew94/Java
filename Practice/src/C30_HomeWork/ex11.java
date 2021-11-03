package C30;

import java.io.*;
import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) throws FileNotFoundException {
        String oldLine = "";
        FileWriter outputFile = null;       //  do not forget to delete outputf.txt

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("TextInput.txt")))) {
            while (scanner.hasNextLine()) {
                oldLine = scanner.nextLine();
                if (oldLine.contains("fotbal")) {
                    oldLine = oldLine.replace("fotbal", "volei");
                }
                //System.out.println("OLD: " + oldLine);

                try {
                    if(outputFile == null) outputFile = new FileWriter("output.txt");

                    outputFile.write(oldLine);
                    outputFile.write("\n");

                } catch (IOException e) {
                    System.out.println("Something wrong has happened...");
                    e.printStackTrace();
                }
            }

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

