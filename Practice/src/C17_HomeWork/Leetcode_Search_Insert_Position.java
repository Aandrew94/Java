package C17_HomeWork;

public class Leetcode_Search_Insert_Position {
    public static void main(String[] args) {

        int[] array = {3, 6, 9, 12, 15, 18, 21};
        int[] arr = {1, 3, 5, 7};
        int[] sing = {1};
        System.out.print("Array:\t");
        printArray(arr);

        System.out.println("\nGeting number:");
        for (int i = -1; i <= 25; ++i) {
            System.out.println("[fct I]  " + i + " pe poz " + binarySearch(array, i));
            System.out.println("[fct II] " + i + " pe poz " + binarySearchPro(array, i));
        }

    }

    public static int binarySearch(int[] array, int number) {
        int hight   =   array.length - 1;
        int low     =   0;


        while (low <= hight) {
            int middle = low + (hight - low) / 2;

            if (number == array[middle]) {
                System.out.println("[*]\tNumarul " + number + " a fost gasit si se afla pe pozitia " + middle);
                return middle;
            } else if (number < array[middle]) {
                int lowLeft = low;
                int highRight = low + 1;

                if (middle == 0 && number < array[lowLeft]) {           //  daca sunt la limita de jos a array-ului
                    System.out.println("Numarul " + number + " nu a fost gasit, dar poate fi inserat pe pozitia " + lowLeft);
                    return lowLeft;
                }

                if (number > array[lowLeft] && number < array[highRight]) {
                    System.out.println("Numarul " + number + " nu a fost gasit, dar poate fi inserat pe pozitia " + (lowLeft + 1));
                    return (lowLeft + 1);
                }

                hight = middle - 1;
            } else {
                int lowLeft = middle;
                int highRight = middle + 1;

                if (number > array[lowLeft] && highRight > hight) {       //  daca sunt la limita de sus array-ului
                    System.out.println("Numarul " + number + " nu a fost gasit, dar poate fi inserat pe pozitia " + highRight);
                    return highRight;
                }

                if (number > array[lowLeft] && number < array[highRight]) {
                    System.out.println("Numarul " + number + " nu a fost gasit, dar poate fi inserat pe pozitia " + highRight);
                    return highRight;
                }

                low = middle + 1;
            }

        }
        return -1;      //  error
    }
    public static int binarySearchPro(int[] array, int number) {
        int right   = array.length - 1;
        int left    =   0;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == number){
                return middle;
            }
            if (number < array[middle]){
                right = middle - 1;
            }
            else left = middle + 1;
        }

        return left;
    }
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}

