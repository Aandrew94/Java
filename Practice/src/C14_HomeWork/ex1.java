package C14_EX1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {


        public static void matrixOfArray(int matrixDimension, int mainDiagValue, int sndDiagValue, int  centerValue,
                                         int leftValue, int upValue, int rightValue, int bottomValue){

            int matrix[][] = new int[matrixDimension][matrixDimension];     //  [rows][columns]

            for(int i=0;i<matrix.length;++i){
                for(int j=0;j<matrix[i].length;++j){
                    int aux = 0;

                    if(i == j){                                 //  diagonala principala
                        aux = mainDiagValue;
                    }else if(i+j == matrixDimension - 1) {      //  diagonala secundara
                        aux = sndDiagValue;
                    }else if(i < j){                            //  deasupra diagonalei principale
                        if(i+j < matrixDimension - 1){
                            aux = upValue;
                        } else {
                            aux = rightValue;
                        }
                    }else{                                      //  sub diagonala principala
                        if(i+j < matrixDimension - 1){
                            aux = leftValue;
                        } else{
                            aux = bottomValue;
                        }
                    }

                    matrix[i][j] = aux;

                    if(matrixDimension % 2 != 0){
                        matrix[matrixDimension/2][matrixDimension/2] = centerValue;
                    }

                }
            }


            printMatrix(matrix);
        }

        public static void matrixOfArrayLists(int matrixDimension, int mainDiagValue, int sndDiagValue, int  centerValue,
                                              int leftValue, int upValue, int rightValue, int bottomValue){

            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(matrixDimension);
            for(int i=0;i<matrixDimension;++i){
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0;j<matrixDimension;++j){
                    row.add(0);
                }
                matrix.add(row);
            }

            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    int aux = 0;

                    if (i == j) {
                        // diagonala principala
                        aux = mainDiagValue;
                    } else if (i + j == matrixDimension - 1) {
                        // diagonala secundara
                        aux = sndDiagValue;
                    } else if (i < j) {
                        // deasupra diagonalei principale
                        aux = i + j < matrixDimension - 1 ? upValue : rightValue;
                    } else {
                        // sub diagonala principala
                        aux = i + j < matrixDimension - 1 ? leftValue : bottomValue;
                    }

                    matrix.get(i).set(j, aux);

                    if (matrixDimension % 2 != 0) {
                        matrix.get(matrixDimension / 2).set(matrixDimension / 2, centerValue);
                    }


                }
            }

            for (ArrayList<Integer> row : matrix){
                System.out.println(row);
            }

        }



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int[] input = new int[8];
            System.out.println(input.length);
            int matrixDimension = 0;
            int mainDiagValue = 0;
            int sndDiagValue = 0;
            int centerValue = 0;
            int leftValue = 0;
            int upValue = 0;
            int rightValue = 0;
            int bottomValue = 0;


            for(int i=0;i<input.length;++i){
                switch(i) {
                    case 0:
                        System.out.print("matrixDimension:\t");
                        matrixDimension = sc.nextInt();
                        input[i] = matrixDimension;
                        break;
                    case 1:
                        System.out.print("mainDiagValue:\t");
                        mainDiagValue = sc.nextInt();
                        input[i] = mainDiagValue;
                        break;
                    case 2:
                        System.out.print("sndDiagValue:\t");
                        sndDiagValue = sc.nextInt();
                        input[i] = sndDiagValue;
                        break;
                    case 3:
                        System.out.print("centerValue:\t");
                        centerValue = sc.nextInt();
                        input[i] = centerValue;
                        break;
                    case 4:
                        System.out.print("leftValue:\t");
                        leftValue = sc.nextInt();
                        input[i] = leftValue;
                        break;
                    case 5:
                        System.out.print("upValue:\t");
                        upValue = sc.nextInt();
                        input[i] = upValue;
                        break;
                    case 6:
                        System.out.print("rightValue:\t");
                        rightValue = sc.nextInt();
                        input[i] = rightValue;
                        break;
                    case 7:
                        System.out.print("bottomValue:\t");
                        bottomValue = sc.nextInt();
                        input[i] = bottomValue;
                        break;

                    default:
                        System.out.println("error :(");
                        break;
                }
            }

            printOptions(input);
            matrixOfArray(matrixDimension,mainDiagValue,sndDiagValue,centerValue,
                    leftValue,upValue,rightValue,bottomValue);

            matrixOfArrayLists(matrixDimension,mainDiagValue,sndDiagValue,centerValue,
                    leftValue,upValue,rightValue,bottomValue);

        }


        public static void printMatrix(int[][] matrix){
            for(int i=0;i<matrix.length;++i){
                for (int j=0;j<matrix[i].length;++j){
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void printOptions(int[] options){
            System.out.println("\nMatrix Details:");
            for(int i=0;i<options.length;++i){
                System.out.print(options[i] + "\t");
            }
            System.out.println("\n");
        }

}
