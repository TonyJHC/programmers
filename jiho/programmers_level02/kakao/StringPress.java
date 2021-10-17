package com.company.programmers.kakao;

/**
 * Created by JihoKevin.
 * User: sinjiho
 * Date: 2021/10/08
 * Time: 4:31 오후
 */
public class StringPress {

    public static void main(String[] args) {

        String s = "aabbaccc";

        System.out.println(solution(s));
    }

    public static String solution(String s) {

        String answer = "";
        int j = 0;

        for (int i = 1; i <= s.length() / 2; i++) {
            String result = "";
            String left = s.substring(0, i);
            int cnt = 1;
            for (j = i; j <= s.length(); j += i) {
                String right = "";
                if ((j + i) >= s.length()) {
                    right = s.substring(j);
                } else {
                    right = s.substring(j, j + i);
                }
                if (left.equals(right)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        result += cnt;
                    }
                    result += left;
                    // 길이가 다 됐을 때 남은 값은 더이상 안쪽 for문을 타지 않으므로 밖에서 한번 더 붙여준다.
                    // 남지 않고 계속 for문을 탈때는 어차피 남는 부분이 없이 공백이기 때문에...!
                    left = right;
                    cnt = 1;
                }
            }
            result += left;
            answer += result + " ";
        }
        return answer;
    }
}
