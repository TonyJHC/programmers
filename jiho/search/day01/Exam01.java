package com.company.search.day01;

public class Exam01 {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};

        seqSearchSen(a, a.length, 3); // while
        seqSearchSenFor(a, a.length, 4); // for

    }

    // while문
    public static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        while (true) {
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

    // while문
    public static void seqSearchSenFor(int[] a, int n, int key) {
        int i;

        for (i = 0; i < n; i++) {
            if (i == n) {
                System.out.println("값이 존재하지 않습니다.");

            } else if (a[i] == key) {
                System.out.println(i + "번째에 존재합니다.");

            }
        }
    }

}
