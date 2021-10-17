package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/24
 * Time: 6:58 오후
 */
public class RecursiveArrayGcd {

    static int gcd(int x, int y) {

        int temp;

        while (y > 0) {
            temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }

    // 간접 재귀 활용..!
    static int gcdArray(int[] a, int position) {
        if (a[position] == 0)
            return a[position];
        else
            return gcd(a[position], a[position + 1]);
    }

    public static void main(String[] args) {
        int[] array = new int[]{36, 8, 12, 32, 16};
        System.out.println(gcdArray(array, 0));
    }
}
