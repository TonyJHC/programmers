package com.company.programmers;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/07
 * Time: 8:46 오전
 */

class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0, hitCnt = 0, fstCnt = 0, scdCnt = 0;
        int[] prize = new int[]{6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zeroCnt++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) hitCnt++;
            }
        }

        fstCnt = hitCnt + zeroCnt;
        scdCnt = fstCnt - zeroCnt;

        if (scdCnt <= 0) {
            scdCnt = 1;
        }
        if (fstCnt <= 0) {
            fstCnt = 1;
        }

        answer[0] = prize[fstCnt - 1];
        answer[1] = prize[scdCnt - 1];

        return answer;
    }
}

