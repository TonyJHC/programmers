package com.company.search.day01;

public class Exam02 {

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 9, 8, 2, 4};

        seqSearchSen(a, a.length, 4);

    }

    // while문
    public static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;
        System.out.print("   | ");
        for (int j = 0; j < n; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.print("---+");
        for (int k = n; k >= 0; k--) {
            System.out.print("--");
        }
        System.out.println();

        while (true) {

            if (i < n) {
                System.out.print("   |");
                for (int j = 0; j < i; j++) {
                    System.out.printf("%2c", ' ');
                }
                System.out.printf("%2c", '*');
                System.out.printf("\n  %d|", i);
                for (int k : a) {
                    System.out.printf("%2d", k);
                }
                System.out.println();
                System.out.println("   | ");
            }

            if (i == n) {
                System.out.println("값이 존재하지 않습니다.");
                return -1;
            } else if (a[i] == key) {
                System.out.println(i + "번째에 존재합니다.");
                return i;
            }
            i++;
        }
    }
}