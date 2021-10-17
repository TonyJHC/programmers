package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/24
 * Time: 6:24 오후
 */
public class NonRecursiveGcd {


    static int gcd(int x, int y) {

        int temp;

        while (y > 0) {
            temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }


    public static void main(String[] args) {
        System.out.println(gcd(22, 8));
    }
}
