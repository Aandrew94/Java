package C22_Colectia_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ex4and5MergeAndRotate {
    public static void main(String[] args){
        List<Integer> listOne = new LinkedList<>();
        List<Integer> listTwo = new LinkedList<>();

        listOne.add(1); listOne.add(2); listOne.add(4);
        listTwo.add(1); listTwo.add(3); listTwo.add(4);

        System.out.println("ListOne:\t" + listOne);
        System.out.println("ListTwo:\t" + listTwo);

        System.out.println("\nMerge LinkedLists:\t" + ex6Combine.mergeTwoLists(listOne,listTwo));
        System.out.println("Rotate LinkedList:\t"   + ex6Combine.rotateRight(listOne,2));

        List<Integer> arrOne = new ArrayList<>();
        List<Integer> arrTwo = new ArrayList<>();
        arrOne.add(1); arrOne.add(2); arrOne.add(4);
        arrTwo.add(1); arrTwo.add(3); arrTwo.add(4);

        System.out.println("\n\nArrOne:\t" + arrOne);
        System.out.println("ArrTwo:\t" + arrTwo);

        System.out.println("\nMerge ArrayList:\t" + ex6Combine.mergeTwoLists(arrOne,arrTwo));
        System.out.println("Rotate ArrayList:\t"   + ex6Combine.rotateRight(arrOne,1));
    }


}
