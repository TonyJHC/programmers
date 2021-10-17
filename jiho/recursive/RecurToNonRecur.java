package com.company.search.day04;

import com.company.search.day02.stack.IntStack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 1:59 오후
 * recur 메서드를 비 재귀적으로 구현하는 문제. Stack을 이용함.
 */
public class RecurToNonRecur {

    static void recur(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) {
                n = s.pop();
                n = n - 2;
                System.out.println(n);
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        recur(4);

    }
}
