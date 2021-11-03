package C30;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex1OPT {
    public static void  main(String[] args) throws FileNotFoundException {
        List<String> getInfo = new ArrayList<>();
        List<String> newInfo = new ArrayList<>();

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("TextInput.txt")))) {
            while(scanner.hasNextLine()) {
                getInfo.add(scanner.nextLine());
            }
        }

        for(String ss : getInfo){
            String tmp = ss.replace("fotbal","volei");
            newInfo.add(tmp);
//            System.out.println(ss);
        }
//        for(String ss : newInfo){
//            System.out.println(ss);
//        }

/**
 * Write into the file
 */
        try(BufferedWriter outputFile = new BufferedWriter(new FileWriter("TextInput.txt"))) {
            for (String word : newInfo) {
                    outputFile.write(word);
                    outputFile.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
