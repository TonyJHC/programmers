import java.util.Scanner;

public class IntervalX {
    int x;
    int n;
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i=0; i<n; i++) {
            answer[i] = (long) x*(i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner cn = new Scanner(System.in);
        System.out.print("x: ");
        int x = cn.nextInt();
        System.out.print("n: ");
        int n = cn.nextInt();
        long[] answer = solution(x, n);
        for (int i=0; i<n; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
