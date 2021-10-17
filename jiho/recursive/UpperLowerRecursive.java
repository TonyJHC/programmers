package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 1:38 오전
 */
public class UpperLowerRecursive {

    static void recurUpper(int n) {
        if (n > 0) {
            recurUpper(n - 2);
            System.out.println(n);
            recurUpper(n - 1);
        }
    }


    public static void main(String[] args) {
        recurUpper(4);
    }
}
