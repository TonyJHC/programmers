package com.example.tony.Baekjun.JumpNumTables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    static List<String> numsList = new ArrayList<String>();
    static int count = 0;
    static String tmpStr = new String();


    public static void dfs(int[][] numbers, int r, int c, String str) {
        tmpStr = str;

        if (tmpStr.length() == 6) { // 길이가 6이고
            if (!numsList.contains(tmpStr)) { // 서로 다른 수
                numsList.add(tmpStr); // 추가
                count++; // 개수 카운트 증가 ++

            } else { // 길이가 6이지만 같은수라면
                tmpStr = tmpStr.replaceAll(str,""); // 문자열 비우기 -> length = 0 으로 초기화
            }
            return;
        }

        //길이가 6이 아니라면
        tmpStr +=numbers[r][c]; // 해당 숫자 tmpStr에 추가

        if (c < 0 || c > 4 || r < 0 || r > 4 || r - 1 < 0 || r + 1 > 4 || c + 1 > 4 || c - 1 < 0) // 인덱스 범위 벗어나면
            return; // 반환

        dfs(numbers, r - 1, c, tmpStr); // 상
        dfs(numbers, r + 1, c, tmpStr); // 하
        dfs(numbers, r, c - 1, tmpStr); // 좌
        dfs(numbers, r, c + 1, tmpStr); // 우

    }


    public static void main(String[] args) {
        int[][] numbers = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1},
                {1, 1, 1, 1, 1}};

        dfs(numbers, 0, 0, "");
        System.out.println("count : "+count);
    }
}
