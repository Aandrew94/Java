package C16_HomeWork_LeetCode;

import java.util.ArrayList;

public class LeetCode_KeyboardRow_E {

    public static void main(String[] args) {
        String[]    test1   =   {"Hello", "Alaska", "Dad", "Peace"};
        String[]    test2   =   {"omk"};
        String[]    test3   =   {"qwe", "adsdf", "sfd", "iop"};
        String[]    test4   =   {};

        tryTest(test1);
        tryTest(test2);
        tryTest(test3);
        tryTest(test4);
    }

    public  static  void    tryTest(String[] words){
        String rowZero  =   "qwertyuiop";
        String rowOne   =   "asdfghjkl";
        String rowTwo   =   "zxcvbnm";

        ArrayList<String> results = new ArrayList<>(0);


        for(int i=0;i<words.length;++i){
            if(isInRow(words[i].toLowerCase(),rowZero)){
                String theWord = searchForWordInRow(words[i],rowZero);
                if(theWord != null){
                    results.add(theWord);
                }
                continue;
            } else if(isInRow(words[i].toLowerCase(),rowOne)){
                String theWord = searchForWordInRow(words[i],rowOne);
                if(theWord != null){
                    results.add(theWord);
                }
                continue;
            } else if(isInRow(words[i].toLowerCase(),rowTwo)){
                String theWord = searchForWordInRow(words[i],rowTwo);
                if(theWord != null){
                    results.add(theWord);
                }
                continue;
            }
            break;
        }

        String[] stringArray = new String[results.size()];
        for(int i=0;i<results.size();++i){
            stringArray[i] = results.get(i);
        }
        results = null;

        printArray(stringArray);
        //return stringArray;                   //  for LeetCode
    }
    private static  boolean isInRow(String word, String row){
        char firstLetter = word.charAt(0);
        for(int i=0;i<row.length();++i){
            if(row.charAt(i) == firstLetter){
                return true;
            }
        }
        return false;
    }
    private static  String  searchForWordInRow(String word, String row){
        StringBuilder sb = new StringBuilder();
        String toLower = word.toLowerCase();
        for(int i=0;i<toLower.length();++i){
            for(int j=0;j<row.length();++j){
                if(toLower.charAt(i) == row.charAt(j)){
                    sb.append(word.charAt(i));
                    break;
                }
            }
        }

        if(word.equalsIgnoreCase(sb.toString())){
            System.out.println("[" + sb.toString() + "]Cuvantul a fost gasit complet");
            return sb.toString();
        }

        System.out.println("[" + sb.toString() + "]\tCuvantul NU a fost gasit complet");
        return null;
    }
    private static  void    printArray(String[] array){
        if(array == null){
            System.out.println("[Print]\tArray-ul este gol");
            return;
        }

        System.out.print("[Print]\tArray-ul este:\t[ ");
        for(int i=0;i<array.length;++i){
            System.out.print(array[i] + " ");
        }
        System.out.print("]\n\n");
    }

}
