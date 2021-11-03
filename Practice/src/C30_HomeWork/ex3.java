package C30;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ex3 {
    private static final int COUNT = 5;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] array = new String[COUNT];
        String[] results = new String[COUNT];
        getInfo(sc,array);
        generateResults(array,results);
        write(results);

        System.out.println(longWord(array));
        System.out.println(shortWord(array));
        System.out.println(firstWord(array));
        System.out.println(lastWord(array));
        System.out.println(totalWords(array));



    }

    private static void generateResults(String[] list, String[] array){
        for(int i=0;i<COUNT;++i){
            if(i == 0)  array[i] = longWord(list);
            if(i == 1)  array[i] = shortWord(list);
            if(i == 2)  array[i] = firstWord(list);
            if(i == 3)  array[i] = lastWord(list);
            if(i == 4)  array[i] = totalWords(list);
        }
    }

    private static void write(String[] results){
        FileWriter outputFile = null;
        try {
            if(outputFile == null) outputFile = new FileWriter("result.txt");
            for(String str : results){
                outputFile.write(str + "\n");
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

    private static void sort(String[] list){
        for (int i=0; i<list.length;++i) {
            for (int j=i+1; j<list.length;++j){
                if (list[i].compareTo(list[j]) > 0) {
                    String temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    private static void getInfo(Scanner scan, String[] list){
        System.out.println("Set de caractere, fara spatii, separate doar de ENTER");
        for(int i=0;i<COUNT;++i){
            list[i] = (scan.nextLine());
        }

        sort(list);

        System.out.println("\nIN:\t" + Arrays.stream(list).toList());
    }

    private static String longWord(String[] list){
        String max = list[0];
        for(int i=1;i<list.length;++i){
            if(list[i-1].length() > max.length()){
                max = list[i-1];
            }
        }
        return "MAX:\t" + max;
    }

    private static String shortWord(String[] list){
        String min = list[0];
        for(int i=1;i<list.length;++i){
            if(list[i-1].length() < min.length()){
                min = list[i-1];
            }
        }
        return "MIN:\t" + min;
    }

    private static String firstWord(String[] list){
        return "FST:\t" + list[0];
    }

    private static String lastWord(String[] list){
        return "LST:\t" + list[list.length-1];
    }

    private static String totalWords(String[] list){
        return "TOT:\t" + String.valueOf(list.length);
    }

}
