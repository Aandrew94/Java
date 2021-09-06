package C14_HomeWork;

import java.util.ArrayList;
import java.util.Scanner;

public class CiurulLuiEratostene {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primes = new ArrayList<>(0);

        System.out.println("Get number:\t");
        int input = sc.nextInt();

        //  generate matrix within limited input number
        int[][] matrix = generateMatrix(input);

        //  print matrix
        printMatrix(matrix);

        getPrimesFrom(matrix,primes);
        printMatrix(matrix);
        System.out.println("\nPrime numbers:\n" + primes);
    }

    public static int[][] generateMatrix(int limitNumber){
        if(limitNumber <= 1){
            return null;
        }

        int row = 0;
        if(limitNumber <= 10){
            row = 1;
        } else if (limitNumber % 10 == 0) {
            row = limitNumber / 10;
        } else {
            row = (limitNumber/10) + 1;
        }

        int[][] generatedMatrix = new int[row][10];
        int temp = 0;

        for(int i=0;i<generatedMatrix.length;++i){
            for(int j=0;j<generatedMatrix[i].length;++j){
                if(temp >= limitNumber){
                    generatedMatrix[i][j] = 0;
                    break;
                }

                if(i == 0 && j == 0){
                    continue;
                }

                if(i == 0 && j == 1){
                    generatedMatrix[i][j] = 2;
                    temp = generatedMatrix[i][j];
                    continue;
                }

                generatedMatrix[i][j] = ++temp;
            }
        }

        return generatedMatrix;
    }

    public static void printMatrix(int[][] matrix){
        if(matrix == null){
            System.out.print("Error");
            return;
        }
        System.out.println("\nView Matrix:");
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void getPrimesFrom(int[][] matrix, ArrayList<Integer> saveToList){
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){

                //  jump after fisrt element
                if (matrix[i][j] == 0){
                    continue;
                }

                //  check the matrix for primes
                if(isPrime(matrix[i][j])){
                    saveToList.add(matrix[i][j]);
                    int temp = matrix[i][j];
                    matrix[i][j] = 0;
                    removeThe(temp,matrix);
                }

            }
        }

    }

    private static void removeThe(int number,int[][] fromMatrix){
        for(int i=0;i<fromMatrix.length;++i){
            for(int j=0;j<fromMatrix[i].length;++j){
                if (fromMatrix[i][j] % number == 0){
                    fromMatrix[i][j] = 0;
                }
            }
        }
    }

    private static boolean isPrime(int number){
        for(int i=2;i<Math.sqrt(number);++i){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}
