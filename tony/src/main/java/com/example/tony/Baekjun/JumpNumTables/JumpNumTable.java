package com.example.tony.Baekjun.JumpNumTables;

import java.util.ArrayList;
import java.util.List;

public class JumpNumTable {
    int count = 0;
    List<String> sixStrList = new ArrayList<>();
    String sixNum = new String();
    int index = 0;

    public int solution(int[][] numbers, int targetLength) {
//        int count = 0;
        int answer = 0;
        int startR = 0;
        int startC = 0;
        dfs(numbers, 0, startR, startC, targetLength);
        answer = count;

        return answer;

    }

    public void dfs(int[][] numbers, int depth, int startR, int startC, int targetLength) {
        System.out.println("------"+count);
        if (startC >= targetLength-1 || startC < 0 || startR >= targetLength-1 || startR < 0) // 인덱스 넘어가면
            return; // 스택에 쌓여있는 재귀호출 return

        if (depth == targetLength && sixNum.length() == 6 && !sixStrList.contains(sixNum)) { // 6자리고 서로다른 숫자여야, depth 오류 지금 6까지 가버림
            sixStrList.add(sixNum); // 6자리 숫자의 리스트에 추가
            count++;
            return; // 추가하고 다시 돌아가서 다른 경우의 수 탐색 : dfs 호출
        }

        if (sixNum.length() < 6 && startR < 5 && startR >= 0) { // 6자리 미만이여야
            sixNum += String.valueOf(numbers[startR][startC]); // 추가
        }else if(sixNum.length() == 6){
            sixNum = "";
        }

        if (startC < 5 && startC >= 0 && startR < 5 && startR >= 0) { // 인덱스 넘어가는거 방지

            dfs(numbers, depth + 1, startR, startC + 1, targetLength);  // 우
            dfs(numbers, depth + 1, startR, startC - 1, targetLength);  // 좌
            dfs(numbers, depth + 1, startR - 1, startC, targetLength);  // 상
            dfs(numbers, depth + 1, startR + 1, startC, targetLength);  // 하

        } else   // 넘어가면
            return; // ex) 좌측으로 갔는데 인덱스를 넘어가는경우라면 그 다음 재귀인 dfs : 상 을 호출함.

    }


    public static void main(String[] args) {
        JumpNumTable jumpNumTable = new JumpNumTable();
        int[][] numbers = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1},
                {1, 1, 1, 1, 1}};

//        for (int i = 0; i < numbers.length; i++) {
        int result = jumpNumTable.solution(numbers, 6);
        System.out.println(result + "개");
//        }


    }
}
