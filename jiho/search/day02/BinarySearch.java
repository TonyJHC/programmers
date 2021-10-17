package com.company.search.day02.search;

/**
 * 2021.08.05
 * 검색 - Binary Search 삽입 포인트 위치 구하기
 **/
public class BinarySearch {

    public static void main(String[] args) {

        int[] x = new int[]{5, 7, 15, 28, 29, 31, 39, 58, 68, 70};

        System.out.println(binarySearch(x, 71));

    }


    static int binarySearch(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;
        do {

            int pc = (pl + pr) / 2;

            if (arr[pc] == key) {
                System.out.println(pc + "번째에 있습니다.");
                return pc;
            } else if (arr[pc] < key) {
                pl = pc + 1;
            } else if (arr[pc] > key) {
                pr = pc - 1;
            }
        } while (pl <= pr);

        if (pl == arr.length - 1) {
            return arr.length;
        } else {
            return pl;
        }

    }
}
