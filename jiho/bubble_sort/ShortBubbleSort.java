package com.company.search.day05;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/09/10
 * Time: 7:12 오후
 */
public class ShortBubbleSort {

    public static void main(String[] args) {

        int[] a = new int[]{ 1,2,3,4,9,8,5,7,6,10};
        bubbleSort(a, a.length);

        for(int b : a){
            System.out.print(b + " ");
        }

    }

    public static void bubbleSort(int[] a, int n) {
        // k를 0으로 초기화 해 주는 이유는 함수가 처음 실행될 때
        // 전체를 훑으면서 마지막에 교환된 위치를 반환하여
        // 범위를 좁혀줘야 하기 때문이다.
        int k = 0;
        //while : 처음 실행 한번 이후에는 k보다 큰 범위로 범위를 좁힌다.
        while (k < n - 1) {
            // 마지막으로 교환된 위치를 저장하는 last
            int last = n - 1;
            // for문은 k보다 큰 변수를 항상 last에 넣어주며 while문의 범위를 좁혀준다.
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    public static void swap(int[] a, int a1, int a2) {
        int t = a[a1];
        a[a1] = a[a2];
        a[a2] = t;
    }
}
