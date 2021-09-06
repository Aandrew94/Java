package dev.c14;

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        int[][] arrA = new int[][]{{2, 10}, {8, 1}, {5, 5}};
        int[][] arrB = new int[][]{{4, 7}, {0, 3}, {5, 10}};

        int[][] ad = adunare(arrA, arrB);
        int[][] sc = scadere(arrA, arrB);
        int[][] inmSc = inmultireScalar(2, arrB);

        int[][] arrC = new int[][]{{2, 3}, {6, 1}, {5, 1}};
        int[][] arrD = new int[][]{{4, 3, 0}, {5, 5, 1}};
        int[][] inm = inmultire(arrC, arrD);

        //for (int[] row : ad) System.out.println(Arrays.toString(row));
        //for (int[] row : sc) System.out.println(Arrays.toString(row));
        //for (int[] row : inmSc) System.out.println(Arrays.toString(row));
        for (int[] row : inm) System.out.println(Arrays.toString(row));
    }

    private static int[][] adunare(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Adunarea se poate face doar pentru matrici cu aceleasi dimensiuni.");
            return null;
        }

        int[][] res = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }

        return res;
    }

    private static int[][] scadere(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Scaderea se poate face doar pentru matrici cu aceleasi dimensiuni.");
            return null;
        }

        int[][] res = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }

        return res;
    }

    private static int[][] inmultireScalar(int sc, int[][] a) {
        int[][] res = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] * sc;
            }
        }

        return res;
    }

    private static int[][] inmultire(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Numarul de coloane din A nu este egal cu numarul de randuri din B.");
            return null;
        }

        int[][] res = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;

                for (int k = 0; k < a[0].length; k++)
                    sum += a[i][k] * b[k][j];

                res[i][j] = sum;
            }
        }

        return res;
    }
}
