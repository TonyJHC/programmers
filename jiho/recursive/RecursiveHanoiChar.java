package com.company.search.day04;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/08/25
 * Time: 1:15 오후
 * 하노이 탑 문제의 기둥 이름을 문자열 기둥A, 기둥B, 기둥C 로 출력하는 문제
 */
public class RecursiveHanoiChar {

    static void move(int no, int xLength, int yLength) {

        String s[] = new String[]{"A기둥", "B기둥", "C기둥"};

        if (no > 1)
            move(no - 1, xLength, 6 - xLength - yLength);

        System.out.println("원반 " + no + "를 " + s[xLength - 1] + "에서 " + s[yLength - 1] + "으로 옮김.");

        if (no > 1)
            move(no - 1, 6 - xLength - yLength, yLength);
    }

    public static void main(String[] args) {

        move(3, 1, 3);

    }
}
