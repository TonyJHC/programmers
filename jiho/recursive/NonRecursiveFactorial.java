package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/24
 * Time: 5:59 오후
 */
public class NonRecursiveFactorial {

//    static int factorial(int n){
//        if(n > 0){
//            return n * factorial(n - 1);
//        } else {
//            return 1;
//        }
//    }

    static int fatorial(int n){

        int result = 1;

        while(n > 0){
            result = result * n;
            n--;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(fatorial(0));
    }
}
