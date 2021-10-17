package com.company.search.day04;

import com.company.search.day02.stack.IntStack;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 2:15 오후
 * 하노이의 탑을 비 재귀적으로 구현 한 문제.
 */
public class NonRecursiveHanoi {

    static void move(int no, int x, int y) {
        IntStack s = new IntStack(no); // 스택(시작 막대기)
        while (true) {
            if (no > 0) {
                s.push(no);
                System.out.println(s.peek());
                no = no - 1;
                x = 6 - x - y;
//                continue;
            }
//            if (!s.isEmpty()) {
//                no = s.pop();
//                y = 6 - x - y;
//                System.out.println("원반 " + no + "를 " + x + "번째 기둥에서 " + y + "번 째 기둥으로 옮김.");
//                continue;
//            }
            break;
        }

    }

    public static void main(String[] args) {
        move(3, 1, 3);
    }

}
