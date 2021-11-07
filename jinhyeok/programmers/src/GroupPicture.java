public class GroupPicture {
    public static int solution(int n, String[] data) {
        int answer = 0;

        for (int i=0; i<n; i++) {  // 데이터 조건 열람
            String code = data[i]; // 문자열 조건 코드
            char[] arrCode = code.toCharArray();
            /* 조건 코드 분석
            idx=0, 2=>사람; idx=1=>관계성(자신(0), 상대방(2)); idx=3=>거리조건; idx=4=>거리
            */
            char me = arrCode[0]; // 조건을 제시한 사람
            char opnt = arrCode[1]; // 상대방
            char direction = arrCode[3]; // 조건 내용
            char interval = arrCode[4]; // 간격(거리)


        }
        return answer;
    }
}
