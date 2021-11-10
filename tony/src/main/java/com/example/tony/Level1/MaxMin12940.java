package com.example.tony.Level1;

import com.example.tony.TonyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

public class MaxMin12940 {


    public int[] solution(int n, int m) {
        int[] answer = {0, 0};
        int numM = 0;
        int numN = 0;

        if (n < m) {
            numM = m;
            numN = n;
        } else {
            numM = n;
            numN = m;
        }

        // 최대 공약수 구하기
        for (int i = 1; i <= numN; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        // 최소 공배수
        for (int i = numM; i >= numM; i++) {
            if (i % numM == 0 && i % numN == 0) {
                answer[1] = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        MaxMin12940 maxMin12940 = new MaxMin12940();
        maxMin12940.solution(3, 12);
    }

}