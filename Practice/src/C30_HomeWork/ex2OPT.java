package C30;

import java.io.*;
import java.util.Scanner;

public class ex2OPT {
    public static void main(String[] args) throws IOException {
        StringBuilder sb1 = new StringBuilder();

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("Numbers1.txt")))) {
            while(scanner.hasNextLine()) {
                sb1.append(scanner.nextLine());
            }
        }
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("Numbers2.txt")))) {
            while(scanner.hasNextLine()) {
                if(!sb1.toString().isEmpty()) sb1.append(" " + scanner.nextLine());

            }
        }

        String[] one = sb1.toString().split(" ");

        for(int i=0; i < one.length;++i){
            for(int j=1; j < (one.length-i);++j){
                int tmp1 = Integer.parseInt(one[j-1]);
                int tmp2 = Integer.parseInt(one[j]);

                if(tmp1 > tmp2){
                    String temp = one[j-1];
                    one[j-1] = one[j];
                    one[j] = temp;
                }
            }
        }

        try(BufferedWriter outputFile = new BufferedWriter(new FileWriter("NumbersMerge.txt"))) {
            for(int i=0; i < one.length;++i){
                outputFile.write(one[i] + " ");
            }
        }


    }
}
