import java.util.HashMap;
import java.util.HashSet;

public class ColoringBook {
    public static int[] solution(int m, int n, int[][] picture) {
        int maxSizeOfOneArea = 0;
        HashMap<int[], Integer> map = new HashMap<>();
        int[] indexArr = new int[2];
        int y = 0;
        for (;y<m;y++) {
            int x = 0;
            int[] arr = picture[y];
            for (;x<n;x++) {
                Integer areaNum = arr[x];
                indexArr[0] = y;
                indexArr[1] = x;
                map.put(indexArr, areaNum);
            }
        }
        HashSet<HashSet<int[]>> areas = new HashSet<>();
        // 모든 좌표에 대해서 검색해야 하므로, 상하좌우 모두 search되는 메소드가 필요함. getArea 다듬기
        y = 0;
        for (;y<m;y++) {
            int x = 0;
            for (;x<n;x++) {
                indexArr[0] = y;
                indexArr[1] = x;
                areas.add(getArea(indexArr, map));
            }
        }
        int[] answer = new int[2];
        answer[0] = areas.size();
        for (HashSet<int[]> area : areas) {
            if (maxSizeOfOneArea < area.size())
                maxSizeOfOneArea = area.size();
//            for (int[] a : area) {
//                for (int i : a) {
//                    System.out.println(i);
//                }
//                System.out.println();
//            }
        }
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    // 재귀함수. 경로를 search 했을 때, 같은 값이 존재할 때 까지 반복.
    public static HashSet<int[]> getArea(int[] path, HashMap<int[], Integer> map) {
        HashSet<int[]> area = new HashSet<>(); // HashSet이 중복되는 경로를 제거해줄 것
        area.add(path);
        int trgNum = map.get(path); // 영역 대상 숫자
        if (trgNum==0) // 제어. 타깃 값이 0일경우.
            return area;
        int[] column = {0, 0, -1, 1};
        int[] row = {1, -1, 0, 0};
        int[] nxtPath = new int[2];
        // search
        for (int i=0; i < 4; i++) {
            nxtPath[0] = path[0]+column[i]; // column
            nxtPath[1] = path[1]+row[i]; // row
            System.out.println(map.get(path));
            if (map.containsKey(nxtPath)){
                int nxtNum = map.get(nxtPath); // 다음 오른쪽 영역의 숫자
                if (nxtNum==trgNum){
                    area.addAll(getArea(nxtPath, map)); // 재귀로 값이 같지 않을 때까지 추가한 영역 추가
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        for (int a : solution(6, 4, picture)) {
            System.out.println(a);
        }
    }
}
