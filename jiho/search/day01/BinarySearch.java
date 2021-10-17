package com.company.search.day01;

public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int[] d = {1, 2, 3, 5, 6, 8, 9};
        int b[] = new int[a.length];

        //System.out.println("\n개수는 : "+searchIdx(a, a.length, 9, b));

        searchDetail(d, d.length, 9);

    }

    // 크기가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞에서 순서대로 저장.
    // 일치한 요소의 수를 반환하는 메서드
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        int i;
        for (i = 0; i < n; i++) {
            if (key == a[i]) {
                idx[count++] = i;
            }
        }
        for (int j = 0; j < count; j++) {
            System.out.print(idx[j] + " ");
        }
        return count;

//        while (pl <= pr) {
//            int pc = (pl + pr) / 2;
//            if (key == a[pc]) {
//                idx[i++] = pc;
//            } else if (key > a[pc]) {
//                pl = pc + 1;
//            } else {
//                pr = pc - 1;
//            }
//        }
    }

    static int searchDetail(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        System.out.print("   |");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
        System.out.print("---+");
        for (int i = 0; i < n; i++) {
            System.out.print("--");
        }
        System.out.println();

        do {
            int pc = (pl + pr) / 2;

            System.out.print("  |");
            for (int i = 0; i < n; i++) {
                if (i == pc) {
                    System.out.print(" +");
                } else if (i == pl) {
                    System.out.print("<-");
                } else if (i == pr) {
                    System.out.print("->");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

            System.out.printf("%2d|", pc);
            for (int j = 0; j < n; j++)
                System.out.printf("%2d", a[j]);
            System.out.println();
            if (a[pc] == key) {
                return pc;
            } else if (key > a[pc]) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d", a[i]);
        }

        return 0;
    }
}
