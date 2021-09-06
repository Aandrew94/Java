package dev.c14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matrixDimension = sc.nextInt();
        int mainDiagValue = sc.nextInt();
        int sndDiagValue = sc.nextInt();
        int centerValue = sc.nextInt();
        int leftValue = sc.nextInt();
        int upValue = sc.nextInt();
        int rightValue = sc.nextInt();
        int bottomValue = sc.nextInt();

        ex1(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);

        System.out.println();

        ex2(matrixDimension, mainDiagValue, sndDiagValue, centerValue, leftValue, upValue, rightValue, bottomValue);

        sc.close();
    }

    private static void ex1(int matrixDimension, int mainDiagValue, int sndDiagValue, int centerValue,
                            int leftValue, int upValue, int rightValue, int bottomValue) {

        int[][] array = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int num = 0;

                if (i == j) {
                    // diagonala principala
                    num = mainDiagValue;
                } else if (i + j == matrixDimension - 1) {
                    // diagonala secundara
                    num = sndDiagValue;
                } else if (i < j) {
                    // deasupra diagonalei principale
                    num = i + j < matrixDimension - 1 ? upValue : rightValue;
                } else {
                    // sub diagonala principala
                    num = i + j < matrixDimension - 1 ? leftValue : bottomValue;
                }

                if (matrixDimension % 2 != 0) {
                    int t = matrixDimension / 2;
                    array[t][t] = centerValue;
                }

                array[i][j] = num;
            }
        }

        // afiseaza matricea
        for (int[] row : array) System.out.println(Arrays.toString(row));
    }

    private static void ex2(int matrixDimension, int mainDiagValue, int sndDiagValue, int centerValue,
                            int leftValue, int upValue, int rightValue, int bottomValue) {

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();

        for (int i = 0; i < matrixDimension; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < matrixDimension; j++) row.add(0);

            array.add(row);
        }

        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).size(); j++) {
                int num = 0;

                if (i == j) {
                    // diagonala principala
                    num = mainDiagValue;
                } else if (i + j == matrixDimension - 1) {
                    // diagonala secundara
                    num = sndDiagValue;
                } else if (i < j) {
                    // deasupra diagonalei principale
                    num = i + j < matrixDimension - 1 ? upValue : rightValue;
                } else {
                    // sub diagonala principala
                    num = i + j < matrixDimension - 1 ? leftValue : bottomValue;
                }

                if (matrixDimension % 2 != 0) {
                    int t = matrixDimension / 2;
                    array.get(t).set(t, centerValue);
                }

                array.get(i).set(j, num);
            }
        }

        // afiseaza matricea
        for (ArrayList<Integer> row : array) System.out.println(row);
    }
}
