package com.company.programmers.kakao;

import java.util.HashMap;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/11
 * Time: 12:55 오전
 */
public class OpenChat {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        solution(record);
    }

    public static String[] solution(String[] record) {

        int k = 0;
        int j = 0;
        int cnt = 0;

        HashMap<String, String> user_name = new HashMap<String, String>();

        for (int i = 0; i < record.length; i++) {

            String[] temp = record[i].split(" ");
            if (temp[0].equals("Enter")) { // 중복되는 값 없게 키 값이 이미 있으면 교체
                user_name.put(temp[1], temp[2]);
                j++;
            } else if (temp[0].equals("Leave")) { // 나갔다는 것을 출력은 해 줘야해
                j++;
            } else if (temp[0].equals("Change")) {
                user_name.replace(temp[1], temp[2]); // 얘는 바꾸기만 하고
            }
        }
        // 해시 테이블 완성
        // 아래서 부터는 완성된 key - value 값으로 연산이 진행된다.

        String[] answer = new String[j];

        for (; k < record.length; k++) {
            String[] temp = record[k].split(" ");
            if (temp[0].equals("Enter")) {
                answer[cnt++] = user_name.get(temp[1]) + "님이 들어왔습니다.";
            } else if (temp[0].equals("Leave")) {
                answer[cnt++] = user_name.get(temp[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
