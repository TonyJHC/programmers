import java.util.*;

public class Place {
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int c = 0;
        System.out.println(c+"-------");
        for (String[] place : places){
            boolean out = false;
            int[][] path = xySet(place);
            List<int[]> P = new ArrayList<>();
            List<int[]> O = new ArrayList<>();
            List<int[]> X = new ArrayList<>();
            listString(P);
            listString(O);
            listString(X);
            // 'P', 'O', 'X'에 해당하는 좌표 담기
            for (int[] xy:path){
                char ch = place[xy[0]].charAt(xy[1]);
                switch(ch){
                    case 'P':
                        P.add(xy);
                    case 'O':
                        O.add(xy);
                    case 'X':
                        X.add(xy);
                }
            }

            // 두 p좌표 비교 후 타입별 처리하기
            for (int i=1; i<P.size(); i++) {
                int n1 = i-1;
                int n2 = n1+1;
                for (; n2<P.size(); n2++) {
                    int[] first = P.get(n1);
                    int[] second = P.get(n2);
                    int xDif = Math.abs(first[0]-second[0]);
                    int yDif = Math.abs(first[1]-second[1]);
                    int distance = xDif+yDif;
                    if (distance <= 2){
                        // case1
                        if (distance < 2) {
                            out = true;
                            break;
                        }
                        // case2
                        if (xDif == 1) {
                            int[] a = {Math.min(first[0], second[0]), Math.max(first[1], second[1])};
                            int[] b = {Math.max(first[0], second[0]), Math.min(first[1], second[1])};
                            int cnt = 0;

                            for (int[] x : X) {
                                if (a==x || b==x){
                                    cnt++;
                                }
                            }
                            if (cnt!=2) {
                                out=true;
                                break;
                            }
                        }
                        // case3
                        int[] centerX = {(first[0]+second[0])/2, first[1]};
                        int[] centerY = {first[0], (first[1]+second[1])/2};
                        for (int[] o : O) {
                            if (xDif==0)
                                if (o == centerY) {
                                    out = true;
                                }
                            if (yDif==0)
                                if (o == centerX) {
                                    out = true;
                                }
                        }
                        if (out) break;
                    }
                    if (out) break;
                }
            }
            if (!out) answer[c] = 1;
            else answer[c] = 0;
            System.out.println(c+"-------");
            c++;
        }
        return answer;
    }

    private static int[][] xySet(String[] place) {
        int n = place.length*place[0].length();
        int[][] xyArr = new int[n][];
        int cnt = 0;
        for (int x=0; x<place.length; x++) {
            for (int y=0; y<place[x].length(); y++){
                int[] v = {x, y};
                xyArr[cnt] = v;
                cnt++;
            }
        }
        return xyArr;
    }

    private static void arrString(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.print("]\n");
    }

    private static void listString(List<int[]> li) {
        System.out.println("<");
        for (int i = 0;i<li.size();i++) {
            arrString(li.get(i));
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        String[] place = {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"};
        String[][] places = {{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        for (int n : solution(places))
            System.out.println(n);
    }
}
