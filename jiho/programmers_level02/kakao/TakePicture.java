public class TakePicture {
    public static int totalCnt = 0;
    public static String[] kakaoExample = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static void main(String[] args) {
        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};
        String[] data3 = {"A~B<2", "B~A>1"};

        solution(2, data1);
    }

    public static int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
        int answer = totalCnt;
        System.out.println(answer);
        return answer;
    }

    public static void dfs(String names, boolean[] isVisited, String[] datas) {
        if (names.length() == kakaoExample.length - 1) {
            if (check(names, datas)) {
                totalCnt++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + kakaoExample[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    public static boolean check(String searchExample, String[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int position1 = searchExample.indexOf(datas[i].substring(0, 1));
            int position2 = searchExample.indexOf(datas[i].substring(2, 3));
            char op = datas[i].charAt(3);
            int index = datas[i].charAt(4) - '0';
            int resultPos = Math.abs(position1 - position2);
            if (op == '=') {
                if (!(resultPos == index + 1)) return false;
            } else if (op == '>') {
                if (!(resultPos > index + 1)) return false;
            } else if (op == '<') {
                if (!(resultPos < index + 1)) return false;
            }
        }
        return true;
    }
}