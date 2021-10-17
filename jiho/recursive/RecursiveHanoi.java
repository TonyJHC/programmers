package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 1:06 오후
 * 3개의 원판을 3개의 기둥을 이용해 최소한의 횟수로 옮기는 하노이의 탑 알고리즘
 */
public class RecursiveHanoi {

    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.println("원반 " + no + "를 " + x + "번째 기둥에서 " + y + "번 째 기둥으로 옮김.");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {

        move(3, 1, 3);

    }

}
