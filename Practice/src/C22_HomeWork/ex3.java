package C22_Colectia_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class ex3 {
    public static void main(String[] args){
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(2);  l1.add(1);  l1.add(7);  l1.add(8);
        l2.add(5);  l2.add(9);  l2.add(6);

        System.out.print("l1:\t");  printLL(l1);
        System.out.print("l2:\t");  printLL(l2);

        System.out.print("Sum:\t"); printLL(sum(l1,l2));


    }

    public static LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2) {
        if(op1 == null && op2 == null){
            System.out.println("Ambele liste sunt goale");
            return null;
        }
        if(op1 == null) return op2;
        if(op2 == null) return op1;

        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> it1 = op1.descendingIterator();
        Iterator<Integer> it2 = op2.descendingIterator();

        int     min     =   0;
        int     carry   =   0;

        if(op1.size() < op2.size()) min = op1.size();
        else                        min = op2.size();

        while (min > 0) {
            int nr1 = it1.next();
            int nr2 = it2.next();
            int sum = nr1 + nr2 + carry;
            carry   = 0;

            if (sum > 9) {
                carry = sum / 10;
                sum  %= 10;
            }
            result.addFirst(sum);
            --min;
        }

        while (it1.hasNext()) {
            int nr = it1.next() + carry;
            carry  = 0;

            if (nr > 9) {
                carry = nr / 10;
                nr   %= 10;
            }
            result.addFirst(nr);
        }

        while (it2.hasNext()) {
            int nr = it2.next() + carry;
            carry  = 0;

            if (nr > 9) {
                carry = nr / 10;
                nr   %= 10;
            }
            result.addFirst(nr);
        }

        if (carry == 1) result.addFirst(1);
        return result;
    }

    private static void printLL(LinkedList<Integer> linkedList){
        for(int i=0;i<linkedList.size();++i){
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}
