package com.company.search.day05;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/09/10
 * Time: 8:05 오후
 */
public class BidirectionBubbleSort {

    public static void main(String[] args) {

        //int[] a = new int[]{2, 1, 3, 9, 4, 8, 5, 7, 6, 10};
        int[] a = new int[]{6,4,3,7,1,9,8};
        bidirectionBubbleSort(a, a.length);

        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    public static void bidirectionBubbleSort(int[] a, int n) {
        // k를 0으로 초기화 해 주는 이유는 함수가 처음 실행될 때
        // 전체를 훑으면서 마지막에 교환된 위치를 반환하여
        // 범위를 좁혀줘야 하기 때문이다.
        int small = 0;
        int big = n - 1;

        //while : 처음 실행 한번 이후에는 k보다 큰 범위로 범위를 좁힌다.
        while (small < big) {
            int last = big;
            // for문은 k보다 큰 변수를 항상 last에 넣어주며 while문의 범위를 좁혀준다.
            for (int j = big; j > small; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            small = last;

            for (int j = small; j < big; j++) {
                if (a[j] < a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j + 1;
                }
            }
            big = last;
        }
    }


    public static void swap(int[] a, int a1, int a2) {
        int t = a[a1];
        a[a1] = a[a2];
        a[a2] = t;
    }
}
