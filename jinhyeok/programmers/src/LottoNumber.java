public class LottoNumber {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int low_rank = 7;
        int high_rank = 7;
        for (int lot : lottos) {
            if (lot == 0) {
                high_rank--;
            }
        }
        for (int num : win_nums) {
            for (int lot : lottos) {
                if (lot == num) {
                    low_rank--;
                    high_rank--;
                    break;
                }
            }
        }
        if (low_rank==7)
            low_rank = 6;
        if (high_rank==7)
            high_rank = 6;
        answer[0] = high_rank;
        answer[1] = low_rank;
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] sol = solution(lottos, win_nums);
        System.out.println(sol[0]);
        System.out.println(sol[1]);
    }
}
