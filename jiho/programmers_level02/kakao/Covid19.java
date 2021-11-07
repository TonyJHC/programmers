public class Covid19 {

    public static void main(String[] args) {
        String[][] places = {{"PPOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        int ans = 0;
        for (int i = 0; i < places.length; i++) {
            String[][] cusTable = new String[5][5];
            String[][] newCusTable = new String[5][5];
            for (int j = 0; j < places[i].length; j++) {
                cusTable[i] = places[i][j].split("");
                for (int k = 0; k < 5; k++) { // 여기가 각 문자열의 요소 반복문
                    newCusTable[j][k] = cusTable[i][k];
                }
            }
            int cnt = 0;
            for (int l = 0; l < newCusTable.length; l++) {
                for (int m = 0; m < newCusTable[i].length; m++) {
                    cnt = 0;
                    System.out.print(newCusTable[l][m] + " ");
                    if (newCusTable[l][m].equals("X")) continue;
                    if (newCusTable[l][m].equals("P")) {
                        cnt++;
                    }
                    if (l > 0) {
                        if (newCusTable[l - 1][m].equals("P")) {
                            cnt++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (l < newCusTable.length - 1) {
                        if (newCusTable[l + 1][m].equals("P")) {
                            cnt++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (m > 0) {
                        if (newCusTable[l][m - 1].equals("P")) {
                            cnt++;
                        } else {
                            cnt += 0;
                        }
                    }
                    if (m < newCusTable[l].length - 1) {
                        if (newCusTable[l][m + 1].equals("P")) {
                            cnt++;
                        } else {
                            cnt += 0;
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();
            if (cnt >= 2) {
                answer[ans++] = 0;
            } else {
                answer[ans++] = 1;
            }
            for (int q = 0; q < 5; q++) {
                System.out.print(answer[q] + " ");
            }
            System.out.println();
        }
        return answer;
    }
}