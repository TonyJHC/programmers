package com.example.tony.Baekjun.NandM;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N; // N개의 자연수 중
    static int M; // M개를 골라서 수열만들기
    static List<int[]> numSet = new ArrayList<int[]>(); // 결과 출력할 수열 집합 담을 리스트
    static boolean[] visited;
    static int[] tmpnums;
    static int depth = 0;

    public static void dfs(int[] nums) { // depth(M개 고르기) 초기값 0 : M 과 같아질때까지
        if (depth == M) {

            if (!numSet.contains(tmpnums)) {
                numSet.add(tmpnums);
            }

            depth -=1;
            return;
        }
        for (int k = 0; k < N; k++) {
            tmpnums[depth] = nums[k];
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    tmpnums[depth++] = nums[i];
                    visited[i] = true;
                    dfs(nums);
                    visited[i] = false;
                }
            }
        }


    }

    public static void main(String[] args) {
        N = 4; // 4개 자연수 중
        M = 2; // 2개 골라서 수열 만들기

        tmpnums = new int[M]; // 수열을 만드는데 사용되는 배열

        int[] nums = {9, 8, 7, 1}; // 4개 자연수

        visited = new boolean[N]; // 초기값 false

        // 오름차순 정렬
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i : nums) { // 정렬 결과 출력
            System.out.print(i + " "); // 1 7 8 9 로 정렬
        }
        System.out.println();
//        depth = 0;
        dfs(nums);

//        int[] n1 = {1, 7};
//        int[] n2 = {1, 8};

//        numSet.add(n1);
//        numSet.add(n2);

        for (int[] i : numSet) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
