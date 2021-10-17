public class ShortString {
    public static int solution(String s) {
        int answer;
        String result = "";
        String replace = s;
        int unit = 1;
        while (unit <= s.length()/2) {
            int start = 0; // reference 문자열의 시작점
            String ref = "";
            boolean bool = true;
            while (bool) {
                ref = s.substring(start, start+unit);
                int cnt = 1; // 반복 횟수
                int nxt_idx = start + unit; // 다음 문자열 시작 인덱스
                int nxt_last = start + 2 * unit; // 다음 문자열까지 총 길이
                String nxt_str = s.substring(nxt_idx, nxt_last);
                while (ref.equals(nxt_str)) {
                    nxt_idx += unit;
                    nxt_last += unit;
                    if (nxt_last > s.length()) {
                        nxt_str = s.substring(nxt_idx); // 마지막 남은 다음 문자열 중 길이 다른 문자열
                        bool = false; // 남은 문자열을 ref에 담고 while문을 종료시키기 위한 조건
                        break;
                    }
                    nxt_str = s.substring(nxt_idx, nxt_last);
                    cnt++;
                }
                if (cnt > 1)
                    result += String.format("%d%s", cnt, ref);
                else if (!bool){ // cnt++를 스킵하고 while문을 종료시키는 경우. (while(bool)문이 한번에 종료되는 경우)
                    result += String.format("%d%s", 2, ref);
                }
                else
                    result += ref;
                start = nxt_idx;
                ref = nxt_str;
                if (nxt_last+unit>s.length()){  // 이미 비교된 nxt_str은 ref와 다른 상황. 따라서 loop를 끝내고 nxt_str을 ref로 돌려준다.
                    bool = false;
                    ref = s.substring(nxt_idx);
                }
            }
            result += ref;
            if (result.length() < replace.length()){
                replace = result;
            }
            result = "";
            unit++;
        }
        answer = replace.length();
        return answer;
    }

    public static int solution2(String s) {
        String result = "";
        String replace = s;
        for (int unit = 1;unit <= s.length()/2;unit++) {
            int start = 0;
            String ref = "";
            boolean bool = true;
            int cnt = 1;
            while (bool) {
                ref = s.substring(start, start+unit);
                int nxt_idx = start + unit; // 다음 문자열 시작 인덱스
                int nxt_last = nxt_idx + unit; // 다음 문자열까지 총 길이
                if (nxt_last > s.length()) {
                    result += (cnt==1) ? ref : String.format("%d%s", cnt, ref);
                    ref = s.substring(nxt_idx);
                    result += ref;
                    bool = false;
                    continue;
                }
                String nxt_str = s.substring(nxt_idx, nxt_last);
                if (ref.equals(nxt_str)) {
                    cnt++;
                } else if(cnt==1){
                    result += ref;
                } else {
                    result += String.format("%d%s", cnt, ref);
                    cnt=1;
                }
                start = nxt_idx;
            }
//            System.out.println(unit+": "+result);
            if (result.length() < replace.length()){
                replace = result;
            }
            result = "";
        }
        return replace.length();
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution2(s));
    }
}
