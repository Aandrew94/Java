package C22_Colectia_LinkedList;

import java.util.LinkedList;

public class ex2 {
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList();

        //  add elements
        ll.add(1);  ll.add(2);
        ll.add(2);  ll.add(9);
        ll.add(9);  ll.add(10);

        //  print
        printLL(ll);

        //removeDuplicates(ll);
        removeDuplicates2(ll);
        printLL(ll);


    }

    private static void removeDuplicates(LinkedList<Integer> linkedlist){
        for(int i=0;i<linkedlist.size()-1;++i){
            if(linkedlist.get(i) == linkedlist.get(i+1)){
                linkedlist.remove(i);
            }
        }
    }

    private static void removeDuplicates2(LinkedList<Integer> linkedlist){
        for(int i=1;i<linkedlist.size();++i){
            if(linkedlist.get(i-1) == linkedlist.get(i)){
                Integer x = linkedlist.get(i-1);
                i=0;
                while(linkedlist.contains(x)){
                    linkedlist.remove(x);
                }
            }
        }
    }

    private static void printLL(LinkedList<Integer> linkedList){
        for(int i=0;i<linkedList.size();++i){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}
