package C14_EX2;
import java.util.Scanner;

public class ex2 {

    public static void opMatrice(int[][] firstMatrix, int[][] secondMatrix){
        if(firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length){
            System.out.println("Matrix must have the same dimensions for +/- operations");
            return;
        }

        printMatrix(sumTwoMatrix(firstMatrix,secondMatrix));
        printMatrix(difTwoMatrix(firstMatrix,secondMatrix));

        if(firstMatrix.length == secondMatrix[0].length){
            System.out.println("Inmultire posibila");
            printMatrix(prodTwoMatrix(firstMatrix,secondMatrix));

        }




    }
    public static void opMatriceSc(int[][] matrix, int number){
        System.out.println("Inmultire cu " + number);
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                result[i][j] = matrix[i][j] * number;
            }
        }

        System.out.print("Rezultat inmultire cu" + number + " :");
        printMatrix(result);
    }

    private static int[][] sumTwoMatrix(int[][] sqMatrixOne, int[][] sqMatrixTwo){
        int[][] result = new int[sqMatrixOne.length][sqMatrixOne[0].length];
        for(int i=0;i<sqMatrixOne.length;++i){
            for(int j=0;j<sqMatrixOne[i].length;++j){
                result[i][j] = sqMatrixOne[i][j] + sqMatrixTwo[i][j];
            }
        }

        System.out.print("Rezultat adunare:");
        return result;
    }
    private static int[][] difTwoMatrix(int[][] sqMatrixOne, int[][] sqMatrixTwo){
        int[][] result = new int[sqMatrixOne.length][sqMatrixOne[0].length];
        for(int i=0;i<sqMatrixOne.length;++i){
            for(int j=0;j<sqMatrixOne[i].length;++j){
                result[i][j] = sqMatrixOne[i][j] - sqMatrixTwo[i][j];
            }
        }

        System.out.print("Rezultat scadere:");
        return result;
    }
    public static int[][] prodTwoMatrix(int[][] sqMatrixOne, int[][] sqMatrixTwo){
        int[][] result = new int[sqMatrixOne.length][sqMatrixTwo[0].length];
        for(int i=0;i<sqMatrixOne.length;++i){
            for(int j=0;j<sqMatrixTwo[0].length;++j){
                int tempSum = 0;
                for(int x=0;x<sqMatrixOne[0].length;++x){
                    tempSum += sqMatrixOne[i][x]*sqMatrixTwo[x][j];
                }
                result[i][j] = tempSum;
            }
        }

        System.out.print("Rezultat inmultire:");
        return result;
    }

    public static void prodMatrix(int[][] matrixOne, int[][] matrixTwo){

    }




    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        opMatrice(genSqMatrix(input,3), genSqMatrix(input,7));
        opMatriceSc(genSqMatrix(input,3), 10);

        int[][] twoThree = new int[2][3];
        twoThree[0][0] = 1;
        twoThree[0][1] = 2;
        twoThree[0][2] = 3;
        twoThree[1][0] = 4;
        twoThree[1][1] = 5;
        twoThree[1][2] = 6;

        int[][] threeTwo = new int[3][2];
        threeTwo[0][0] = 1;
        threeTwo[0][1] = 2;
        threeTwo[1][0] = 3;
        threeTwo[1][1] = 4;
        threeTwo[2][0] = 5;
        threeTwo[2][1] = 6;

        printMatrix(prodTwoMatrix(twoThree,threeTwo));

    }




    public static int[][] genSqMatrix(Scanner input, int constant){
        System.out.print("Get dimension for a square matrix:");
        int sqMatrixDim = input.nextInt();
        int[][] sqMatrix = new int[sqMatrixDim][sqMatrixDim];

        for(int i=0;i<sqMatrix.length;++i){
            for(int j=0;j<sqMatrix[i].length;++j){
                sqMatrix[i][j] = (i+j)*constant;    //  % constatnt
            }
        }

        printMatrix(sqMatrix);
        return sqMatrix;
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("\nPrinting matrix:");
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }



}