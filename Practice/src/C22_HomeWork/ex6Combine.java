package C22_Colectia_LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ex6Combine {
    public static List<Integer> rotateRight(List<Integer> theList, int nr){
        if(theList == null){
            System.out.println("NULL LinkedList");
            return null;
        }
        if(nr < 0){
            System.out.println("Rotate times must be > 0");
            return theList;
        }
        int listSize = theList.size();
        if(nr % listSize > 0){
            nr %= listSize;
        }

        while(nr != 0){
            theList.add(0,theList.remove(theList.size()-1));
            //theList.add(theList.remove(theList.size()-1));
            --nr;
        }

        return theList;
    }

    public static List<Integer> mergeTwoLists(List<Integer> listOne, List<Integer> listTwo){
        if(listOne == null || listTwo == null){
            System.out.println("NULL Linked List");
            return null;
        }

        ListIterator<Integer> itOne = listOne.listIterator();
        ListIterator<Integer> itTwo = listOne.listIterator();

        LinkedList<Integer> result = new LinkedList<>();
        while(itOne.hasNext() && itTwo.hasNext()){
            int one = itOne.next();
            int two = itTwo.next();

            if(one < two){
                result.add(one);
                result.add(two);
            } else {
                result.add(two);
                result.add(one);
            }
        }

        while(itOne.hasNext()){
            result.add(itOne.next());
        }

        while(itTwo.hasNext()){
            result.add(itTwo.next());
        }

        return result;
    }


}
