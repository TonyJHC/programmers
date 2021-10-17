package com.company.programmers.kakao.heatherSolution;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

/**
 * Created by JihoKevin & Heather
 * User: sinjiho
 * Date: 2021/10/15
 * Time: 10:32 오후
 * desc: 카카오 오픈채팅방 문제 풀이 피드백 중 Heather가
 *      switch-case 를 적용시켜 에러가 난 것을 다같이 수정하는 작업 진행
 */
public class OpenChatHeather {

    public String[] solution(String[] record) {
        String[] newArray;
        HashMap<String, String> nickname = new HashMap<>(record.length);
        int cnt = 0;
        int k = 0;

        //Enter로 시작하는 원소가 있으면 해시맵에 넣기 (uid, nickname)
        //Change로 시작 -> 해시맵.replace(uid, 새로운 닉네임)

        for (String msg : record) {
            if (msg.contains("Enter")) {
                String[] name = msg.split(" ");
                nickname.put(name[1], name[2]);
                cnt++;
            } else if (msg.contains("Change")) {
                String[] name = msg.split(" ");
                nickname.replace(name[1], name[2]);
            } else {
                cnt++;
            }
        }

        newArray = new String[cnt];

        for (String s : record) {
            String[] name = s.split(" ");
            String afterName = nickname.get(name[1]);

            switch (name[0]) {
                case "Enter":
                    newArray[k++] = afterName + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    newArray[k++] = afterName + "님이 나갔습니다.";
                    break;
            }
        }
        return newArray;
    }
}

